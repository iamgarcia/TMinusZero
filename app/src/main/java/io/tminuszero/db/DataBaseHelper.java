package io.tminuszero.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    // Must increment database version if you change database schema.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TMinusZero.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DataBaseContract.DBEntry.TABLE_NAME
            + " (" + DataBaseContract.DBEntry._ID + " INTEGER PRIMARY KEY," +
                    DataBaseContract.DBEntry.COLUMN_NAME_LAUNCH + " TEXT," +
                    DataBaseContract.DBEntry.COLUMN_NET_LAUNCH + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DataBaseContract.DBEntry.TABLE_NAME;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
