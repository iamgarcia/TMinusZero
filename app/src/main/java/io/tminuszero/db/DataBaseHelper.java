package io.tminuszero.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    // Must increment database version if you change database schema.
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "TMinusZero.db";

    // TODO: Find a better way to issue SQL commands
    private static final String SQL_CREATE_LAUNCH_TABLE =
            "CREATE TABLE " + DataBaseContract.DBEntry.LAUNCH_TABLE + " (" +
                    DataBaseContract.DBEntry._ID + " INTEGER PRIMARY KEY," +
                    DataBaseContract.DBEntry.COLUMN_NAME_LAUNCH + " TEXT," +
                    DataBaseContract.DBEntry.COLUMN_NET_LAUNCH + " TEXT," +
                    DataBaseContract.DBEntry.COLUMN_TBDTIME_LAUNCH + " INTEGER," +
                    DataBaseContract.DBEntry.COLUMN_TBDDATE_LAUNCH + " INTEGER," +
                    DataBaseContract.DBEntry.COLUMN_PROBABILITY_LAUNCH + " INTEGER)";

    private static final String SQL_CREATE_FLIGHT_STATUS =
            "CREATE TABLE " + DataBaseContract.DBEntry.FLIGHT_STATUS_TABLE + " (" +
                    DataBaseContract.DBEntry._ID + " INTEGER PRIMARY KEY," +
                    DataBaseContract.DBEntry.COLUMN_STATUS_FLIGHT_STATUS + " INTEGER," +
                    DataBaseContract.DBEntry.COLUMN_HOLD_REASON_FLIGHT_STATUS + " TEXT," +
                    DataBaseContract.DBEntry.COLUMN_FAIL_REASON_FLIGHT_STATUS + " TEXT)";


    private static final String SQL_DELETE_LAUNCH_TABLE =
            "DROP TABLE IF EXISTS " + DataBaseContract.DBEntry.LAUNCH_TABLE;

    private static final String SQL_DELETE_FLIGHT_STATUS_TABLE =
            "DROP TABLE IF EXISTS " + DataBaseContract.DBEntry.FLIGHT_STATUS_TABLE;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_LAUNCH_TABLE);
        db.execSQL(SQL_CREATE_FLIGHT_STATUS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_LAUNCH_TABLE);
        db.execSQL(SQL_DELETE_FLIGHT_STATUS_TABLE);

        onCreate(db);
    }
}
