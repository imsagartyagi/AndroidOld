package com.example.sagartyagi.projects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText c_username,c_password,f_username,f_password;
     Toolbar tbr;
     Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbr=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(tbr);
        loginInto();

    }
    public void loginInto(){
        c_username=(EditText)findViewById(R.id.editText);
        c_password=(EditText)findViewById(R.id.editText3);
        f_username=(EditText)findViewById(R.id.editText2);
        f_password=(EditText)findViewById(R.id.editText4);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1=c_username.getText().toString();
               String password1=c_password.getText().toString();
               if((username1.equals("company"))&&(password1.equals("password c"))){
                    Toast.makeText(MainActivity.this,"Company Login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent("com.example.sagartyagi.projects.Company"));


               }
                else{
                    Toast.makeText(MainActivity.this,"Incorrect company_User Information", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String username2=f_username.getText().toString();
                String password2=f_password.getText().toString();
                if((username2.equals("freelancer"))&&(password2.equals("password f"))){
                    Toast.makeText(MainActivity.this,"FreeLancer Login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent("com.example.sagartyagi.projects.FreeLancer"));

                }
                else{
                    Toast.makeText(MainActivity.this,"Incorrect User Information", Toast.LENGTH_SHORT).show();
                }
           }
        });


    }

}
