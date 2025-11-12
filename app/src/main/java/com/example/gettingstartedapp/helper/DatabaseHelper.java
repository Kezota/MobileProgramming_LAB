package com.example.gettingstartedapp.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gettingstartedapp.model.Note;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NotesDB";
    private static final String TABLE_NOTES = "notes";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_BODY = "body";
    private static final String KEY_LAST_EDITED_AT = "lastEditedAt";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: no 4
        String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_TITLE + " TEXT,"
                + KEY_BODY + " TEXT,"
                + KEY_LAST_EDITED_AT + " INTEGER"
                + ")";

        db.execSQL(CREATE_NOTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }

    public void addNote(Note note) {
        //TODO: no 4
        SQLiteDatabase db = this.getWritableDatabase();

        // cara pakai ContentValues
//        ContentValues values = new ContentValues();
//        values.put(KEY_TITLE, note.getTitle());
//        values.put(KEY_BODY, note.getBody());
//        values.put(KEY_LAST_EDITED_AT, note.getLastEditedAt());
//
//        db.insert(TABLE_NOTES, null, values);

        // cara pakai query langsung
        String INSERT_NOTE = "INSERT INTO " + TABLE_NOTES + " ("
                + KEY_TITLE + ", "
                + KEY_BODY + ", "
                + KEY_LAST_EDITED_AT + ") VALUES ('"
                + note.getTitle() + "', '"
                + note.getBody() + "', "
                + note.getLastEditedAt() + ")";

        db.execSQL(INSERT_NOTE);
        db.close();
    }

    public Note getNote(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NOTES, new String[]{KEY_ID, KEY_TITLE, KEY_BODY, KEY_LAST_EDITED_AT},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Note note = new Note(
                cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getLong(3)
        );
        cursor.close();
        db.close();
        return note;
    }

    public ArrayList<Note> getAllNotes() {
        //TODO: no 4
        ArrayList<Note> noteList = new ArrayList<>();
        String SELECT_ALL_NOTES = "SELECT * FROM " + TABLE_NOTES + " ORDER BY " + KEY_LAST_EDITED_AT + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL_NOTES, null);

        if (cursor.moveToFirst()) {
            do {
                Note note = new Note(
                        cursor.getLong(cursor.getColumnIndexOrThrow(KEY_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(KEY_TITLE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(KEY_BODY)),
                        cursor.getLong(cursor.getColumnIndexOrThrow(KEY_LAST_EDITED_AT))
                );
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return noteList;
    }

    public Note getNoteByTitle(String title) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NOTES, new String[]{KEY_ID, KEY_TITLE, KEY_BODY, KEY_LAST_EDITED_AT},
                KEY_TITLE + "=?", new String[]{title}, null, null, null, null);

        // cara pakai raw query
//        String SELECT_NOTE_BY_TITLE = "SELECT * FROM " + TABLE_NOTES + " WHERE " + KEY_TITLE + "=?";
//
//        Cursor cursor = db.rawQuery(SELECT_NOTE_BY_TITLE, new String[]{title});
//
//        if (cursor != null)
//            cursor.moveToFirst();

        if (!cursor.moveToFirst()) {
            cursor.close();
            db.close();
            return null; // note dengan title tersebut tidak ditemukan
        }

        Note note = new Note(
                cursor.getLong(cursor.getColumnIndexOrThrow(KEY_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(KEY_TITLE)),
                cursor.getString(cursor.getColumnIndexOrThrow(KEY_BODY)),
                cursor.getLong(cursor.getColumnIndexOrThrow(KEY_LAST_EDITED_AT))
        );

        cursor.close();
        db.close();
        return note;
    }

    // ini untuk bantu format timestamp
    public static String formatTimestamp(long timestamp) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault());
            Date date = new Date(timestamp);
            return sdf.format(date);
        } catch (Exception e) {
            return String.valueOf(timestamp);
        }
    }
}