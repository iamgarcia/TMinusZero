package io.tminuszero.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    // Must increment database version if you change database schema.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "TMinusZero.db";


    private static final String SQL_CREATE_LAUNCH_TABLE =
            "CREATE TABLE " + DataBaseContract.DBEntry.LAUNCH_TABLE
            + " (" + DataBaseContract.DBEntry._ID + " INTEGER PRIMARY KEY," +
                    DataBaseContract.DBEntry.COLUMN_NAME_LAUNCH + " TEXT," +
                    DataBaseContract.DBEntry.COLUMN_NET_LAUNCH + " TEXT," +
                    DataBaseContract.DBEntry.COLUMN_TBDTIME_LAUNCH + " INTEGER," +
                    DataBaseContract.DBEntry.COLUMN_TBDDATE_LAUNCH + " INTEGER," +
                    DataBaseContract.DBEntry.COLUMN_PROBABILITY_LAUNCH + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DataBaseContract.DBEntry.LAUNCH_TABLE;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_LAUNCH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
