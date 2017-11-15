package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tijojose27 on 11/13/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "shelter.db";
    public static int DB_VERSION = 1;

    public static String SQL_CREATE_ENTRIES="CREATE TABLE "+PetContract.PetEntry.TABLE_NAME+" ( "+
            PetContract.PetEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            PetContract.PetEntry.COLUMN_PET_NAME+" TEXT NOT NULL, "+
            PetContract.PetEntry.COLUMN_PET_BREED+" TEXT, "+
            PetContract.PetEntry.COLUMN_PET_GENDER+" INTEGER NOT NULL, "+
            PetContract.PetEntry.COLUMN_PET_WEIGHT+" INTEGER NOT NULL DEFAULT 0)";

    public static final String SQL_DELETE_ENTRIES="DROP TABLE IF EXISTS "+ PetContract.PetEntry.TABLE_NAME;


    public PetDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
