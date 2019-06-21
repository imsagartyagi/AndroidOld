package com.example.sagartyagi.projects;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Sagar Tyagi on 08-Jul-17.
 */

public class BackgroundTask1 extends AsyncTask<String,String,String> {
    Context context;
    BackgroundTask1(Context context){
        this.context=context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(String... params) {
        String method=params[0];
        String pname,pdescription;
        CompanyProjectDatabase database=new CompanyProjectDatabase(context);
        if(method=="AddingInformation"){
            pname=params[1];
            pdescription=params[2];
            database.addinformation(pname,pdescription);

        }

        return "one row added.";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
}
