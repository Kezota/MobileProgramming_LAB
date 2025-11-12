package com.example.gettingstartedapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //1. Declare db
    static final String DBNAME ="MyDB.db";
    static final int DBVERSION = 4;

    public DatabaseHelper(Context mCtx){
        super(mCtx,DBNAME,null,DBVERSION);
    }


    //2. Isi OnCreate dan OnUpgradenya
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDao.CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + UserDao.TABLE_USERS);
        onCreate(db);
    }
}
