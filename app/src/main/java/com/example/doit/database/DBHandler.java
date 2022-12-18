package com.example.doit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {


    private static final String DB_NAME = "doIt";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "reminders";
    private static final String ID_COL = "id";
    private static final String Category = "category";
    private static final String message = "message";
    private static final String date = "date";
    private static final String time = "time";

    String val = "CREATE TABLE "+TABLE_NAME+"(\n" +
            "   "+ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "   "+Category+"           TEXT      NOT NULL,\n" +
            "   "+message+"            TEXT       NOT NULL,\n" +
            "   "+date+"        TEXT,\n" +
            "   "+time+"         TEXT\n" +
            ");";

    public DBHandler (Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        /*
        *
                CREATE TABLE "reminders" (
                "id"	INTEGER NOT NULL,
                "Category"	TEXT,
                "message"	TEXT,
                "date"	TEXT,
                "time"	TEXT,
                PRIMARY KEY("id" AUTOINCREMENT)
                );
        *
        *
        * */

//        String query = "CREATE TABLE "+TABLE_NAME+"("+ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Category+" TEXT,"+message+" TEXT, "+date+" TEXT, "+time+" TEXT)";

        // "CREATE TABLE "+TABLE_NAME+"("+ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+Category+" TEXT,"+message+" TEXT, "+date+" TEXT, "+time+" TEXT)"
//        CREATE TABLE one(ID_COL INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Category TEXT, message TEXT, date TEXT, time TEXT)

//        String query = "CREATE TABLE "+TABLE_NAME+"("+
//                ID_COL+ "   INTEGER NOT NULL,"+
//                Category+ "\tTEXT,"+
//                message+ "\tTEXT,"+
//                date+ "\tTEXT,"+
//                time+ "\tTEXT"+
//                "PRIMARY KEY(\"id\" AUTOINCREMENT)"+
//                ");";

//        String query = "CREATE TABLE \"reminders\" (\n                \"id\"\tINTEGER NOT NULL,\n                \"Category\"\tTEXT,\n                \"message\"\tTEXT,\n                \"date\"\tTEXT,\n                \"time\"\tTEXT,\nPRIMARY KEY(\"id\" AUTOINCREMENT)\n);";


//        String query = new StringBuilder().append("CREATE TABLE ").append(TABLE_NAME).append("(").append(ID_COL).append(" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ").append(Category).append(" TEXT, ").append(message).append(" TEXT, ").append(date).append(" TEXT, ").append(time).append(" TEXT)").toString();

        sqLiteDatabase.execSQL(val);

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
