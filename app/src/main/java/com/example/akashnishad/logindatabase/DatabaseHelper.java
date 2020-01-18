package com.example.akashnishad.logindatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Demo.db";
    public static final String TABLE_NAME="Signup";
    public static final String COL_1="LoginID";
    public static final String COL_2="FullName";
    public static final String COL_3="EmailID";
    public static final String COL_4="Password";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +"(LOGINID String PRIMARY KEY,FULLNAME TEXT,EMAILID TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String loginid,String fullname, String emailid,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_1,loginid);
        cv.put(COL_2,fullname);
        cv.put(COL_3,emailid);
        cv.put(COL_4,password);
        long result=db.insertOrThrow(TABLE_NAME,null,cv);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM " + TABLE_NAME + " WHERE LOGINID = '"+id+"'";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
}
