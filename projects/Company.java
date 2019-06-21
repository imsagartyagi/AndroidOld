package com.example.sagartyagi.projects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Company extends AppCompatActivity {
     EditText e1,e2;
     Toolbar tbrCompany;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        e1=(EditText)findViewById(R.id.pname);
        e2=(EditText)findViewById(R.id.pdescription);
        tbrCompany=(Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(tbrCompany);
        getSupportActionBar().setTitle("Company");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){

            case R.id.logout:
                Intent intent=new Intent(Company.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                Toast.makeText(Company.this, "Logout", Toast.LENGTH_SHORT).show();

        }


        return super.onOptionsItemSelected(item);
    }

    public void addproject(View view) {
        BackgroundTask1 task1=new BackgroundTask1(Company.this);
        task1.execute("AddingInformation",e1.getText().toString(),e2.getText().toString());
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
