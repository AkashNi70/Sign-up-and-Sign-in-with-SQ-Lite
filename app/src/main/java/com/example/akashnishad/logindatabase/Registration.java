package com.example.akashnishad.logindatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    DatabaseHelper dbh;
    TextView next;
    EditText fullname,emailid,login,password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        dbh = new DatabaseHelper(this);
        next = findViewById(R.id.login);
        fullname = (EditText) findViewById(R.id.name);
        emailid = (EditText) findViewById(R.id.email);
        login = (EditText) findViewById(R.id.loginid);
        password = (EditText) findViewById(R.id.pass);
        btn = (Button) findViewById(R.id.signup);
        addData();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registration.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void addData(){
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = dbh.insertData(login.getText().toString(),fullname.getText().toString(), emailid.getText().toString(), password.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(Registration.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Registration.this,"Data Not Inserted",Toast.LENGTH_LONG).show();

                        fullname.setText("");
                        emailid.setText("");
                        login.setText("");
                        password.setText("");
                    }
                }
        );
    }
}
