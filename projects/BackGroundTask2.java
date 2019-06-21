package com.example.sagartyagi.projects;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Sagar Tyagi on 09-Jul-17.
 */

public class BackGroundTask2 extends AsyncTask<String,String,String> {
    Context context;
    BackGroundTask2(Context context){
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        YourProjectDataBase dataBase2=new YourProjectDataBase(context);
        String Name,Description,methods;
        methods=params[0];
        if(methods.equals("Adding information")) {
            Name = params[1];
            Description = params[2];
            dataBase2.addingdata(Name, Description);
        }
        return "one Row added man";
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
