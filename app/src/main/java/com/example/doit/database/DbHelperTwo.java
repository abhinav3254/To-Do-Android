package com.example.doit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelperTwo extends SQLiteOpenHelper {

    public static String DB_NAME = "Abhinav";
    public static int version = 1;

    public DbHelperTwo(@Nullable Context context) {
        super(context, DB_NAME,null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE reminders (id INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT, message TEXT,date TEXT,time TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    public boolean insertData (String category, String message, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("category",category);
        contentValues.put("message",message);
        contentValues.put("date",date);
        contentValues.put("time",time);

        long result = db.insert("reminders",null,contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
