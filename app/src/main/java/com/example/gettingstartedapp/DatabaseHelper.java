package com.example.gettingstartedapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.gettingstartedapp.dataAccess.PesananDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "toko", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PesananDao.CREATE_TABLE_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PesananDao.TABLE_ORDER);
    }
}
