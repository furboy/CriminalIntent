package com.ctech.aleco.criminalintent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table "+ CrimeDbSchema.CrimeTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                CrimeDbSchema.CrimeTable.Columns.UUID + ", " +
                CrimeDbSchema.CrimeTable.Columns.TITLE + ", " +
                CrimeDbSchema.CrimeTable.Columns.DATE + ", " +
                CrimeDbSchema.CrimeTable.Columns.SOLVED + ", "+
                        CrimeDbSchema.CrimeTable.Columns.SUSPECT +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
}
