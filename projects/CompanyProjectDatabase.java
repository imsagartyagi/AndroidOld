package com.example.sagartyagi.projects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Sagar Tyagi on 08-Jul-17.
 */

public class CompanyProjectDatabase extends SQLiteOpenHelper {
    Context context;
            public final  String Query="create table "+ DatabaseContracter.DatabaseContainer.TableName+" ("+ DatabaseContracter.DatabaseContainer.col1+
                    " text, "+ DatabaseContracter.DatabaseContainer.col2+" text);";
    public CompanyProjectDatabase(Context context) {

        super(context, DatabaseContracter.DatabaseContainer.Databasename, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("create table if exist "+ DatabaseContracter.DatabaseContainer.TableName);
    }

    public void addinformation(String pname,String pdescription){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseContracter.DatabaseContainer.col1,pname);
        contentValues.put(DatabaseContracter.DatabaseContainer.col2,pdescription);
       long res= db.insert(DatabaseContracter.DatabaseContainer.TableName,null,contentValues);
        if(res!=-1){
            Log.d("String Tag","one row inserted");
        }
    }
    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery(" select * from "+ DatabaseContracter.DatabaseContainer.TableName,null);
        return res;
    }

}
