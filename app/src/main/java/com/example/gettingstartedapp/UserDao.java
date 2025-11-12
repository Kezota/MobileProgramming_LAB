package com.example.gettingstartedapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserDao {

    //1. Declare Table User, Create Table
    static final String TABLE_USERS= "msUser";
    static final String USERS_ID = "id";
    static final String USERS_USERNAME = "username";
    static final String USERS_PASSWORD = "password";

    static  final String CREATE_TABLE_USERS = "CREATE TABLE "+TABLE_USERS+""
            + "("+ USERS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USERS_USERNAME + " TEXT, "
            + USERS_PASSWORD + " TEXT )";

    DatabaseHelper dbHelper;
    public UserDao(DatabaseHelper dbHelper){
        this.dbHelper = dbHelper;
    }

    //2. CRUD
    public long addUser(User user){
        long result = -1;
        SQLiteDatabase db =this.dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USERS_USERNAME, user.username);
        cv.put(USERS_PASSWORD, user.password);

        result = db.insert(TABLE_USERS, null, cv);
        db.close();
        return result;
    }


    @SuppressLint("Range")
    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.query(TABLE_USERS,
                null,
                null,
                null,
                null,
                null,
                null);

        //looping
        while(cursor.moveToNext()){
            User user = new User();
            user.id = cursor.getInt(0);
            user.username = cursor.getString(cursor.getColumnIndex(USERS_USERNAME));
            user.password = cursor.getString(2);
            users.add(user);
        }
        return users;
    }

    public User checkUser(String username, String password){
        User result = new User();
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.query(TABLE_USERS,
                null,
                USERS_USERNAME+"=? AND "+ USERS_PASSWORD+ "=?",
                new String[]{username, password},
                null,
                null,
                null );
        cursor.moveToFirst();
        try{
            if(cursor.getInt(0)>0){
                result.id =cursor.getInt(0);
                result.username = cursor.getString(1);
                result.password = cursor.getString(2);
            }
        }catch (Exception e){
            return  result;
        }
        return  result;
    }
}

