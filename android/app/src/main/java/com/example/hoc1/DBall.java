package com.example.hoc1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBall extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    public DBall(Context context) {
        super(context,"login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(username TEXT primary key, password TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

   public Boolean insertData(String username, String password ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username",username);
        values.put("password",password);

        long result= db.insert("user",null,values);
        if(result==-1) return false;
        else
            return true;

   }
   public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?",new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

   }
   public Boolean checkaccout(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where user=? and password=?",new String[] {username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
   }
}
