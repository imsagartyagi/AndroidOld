package com.example.sagartyagi.projects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sagar Tyagi on 09-Jul-17.
 */

public class YourProjectDataBase extends SQLiteOpenHelper {

    public final String query="create table "+ DatabaseContracter.DatabaseContainer.TableName+" ("+
            DatabaseContracter.DatabaseContainer.col1+" text, "+ DatabaseContracter.DatabaseContainer.col2+" text);";

    public YourProjectDataBase(Context context) {
        super(context, DatabaseContracter.DatabaseContainer.Databasename2, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table if exist "+ DatabaseContracter.DatabaseContainer.TableName);
    }

    public  void addingdata(String name ,String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cntvalues = new ContentValues();
        cntvalues.put(DatabaseContracter.DatabaseContainer.col1, name);
        cntvalues.put(DatabaseContracter.DatabaseContainer.col2, description);
        long isinsert = db.insert(DatabaseContracter.DatabaseContainer.TableName, null, cntvalues);
        if (isinsert != -1) {
            Log.d("String tag", "one row inserted...............");
        }
    }

        public Cursor takedata(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from "+ DatabaseContracter.DatabaseContainer.TableName,null);
        return res;
    }

    }


