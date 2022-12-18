package com.example.doit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.doit.recyclerview.ModelClass;

import java.util.ArrayList;
import java.util.List;

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

//    reading all the values from the database

    public List<ModelClass> readData () {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM reminders",null);

        List<ModelClass> list = new ArrayList<>();
         if(cursor.moveToFirst()) {
             do {
                 list.add(new ModelClass(cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4) ));
             } while (cursor.moveToNext());
         }
         cursor.close();
         return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
