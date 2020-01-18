package com.example.akashnishad.logindatabase;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbs;
    TextView next;
    EditText userid,password;
    Button btn;
    String st1,st2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = new DatabaseHelper(this);
        next =(TextView) findViewById(R.id.sign);
        userid = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,Registration.class);
                startActivity(in);
            }
        });
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String id=userid.getText().toString();
                        String pwd=password.getText().toString();
                        Cursor cursor = dbs.getData(id);
                        while(cursor.moveToNext())
                        {
                            st1=cursor.getString(0);
                            st2=cursor.getString(3);


                            userid.setText("");
                            password.setText("");
                        }
                        if(id.equals(st1)&& pwd.equals(st2))
                            Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"LoginId and Password Incorrect",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }


}
