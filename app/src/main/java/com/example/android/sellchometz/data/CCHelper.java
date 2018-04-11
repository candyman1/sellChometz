package com.example.android.sellchometz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Home on 5/7/2017.
 */

public class CCHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "signin.db";

    private static final int DATABASE_VERSION = 1;

    public CCHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_SIGNIN_TABLE =  "CREATE TABLE " + CContract.CEntry.TABLE_NAME + " ("
                + CContract.CEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CContract.CEntry.COLUMN_SHUL_NAME + " TEXT NOT NULL, "
                + CContract.CEntry.COLUMN_PASSWORD + " TEXT NOT NULL, "
                + CContract.CEntry.COLUMN_RABBI + " TEXT NOT NULL);";


        // Execute the SQL statement
        db.execSQL(SQL_CREATE_SIGNIN_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
