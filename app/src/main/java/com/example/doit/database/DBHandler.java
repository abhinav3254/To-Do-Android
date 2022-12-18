package com.example.doit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {


    private static final String DB_NAME = "doIt";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "reminders";
    private static final String id = "id";
    private static final String category = "category";
    private static final String message = "message";
    private static final String date = "date";
    private static final String time = "time";



    public DBHandler (Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE "+TABLE_NAME+" ("+id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+category+" TEXT, "+message+" TEXT,"+date+" TEXT,"+time+" TEXT);";


        sqLiteDatabase.execSQL(query);

    }

//    adding new to do the database
    public void addNewData (String Category,String message,String date,String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Category,Category);
        values.put(message,message);
        values.put(date,date);
        values.put(time,time);

        db.insert(TABLE_NAME,null,values);

        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
