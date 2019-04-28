package io.tminuszero.db;

import android.provider.BaseColumns;

public final class DataBaseContract {

    // Prevent someone form accidentally instantiating the contract class
    private DataBaseContract() {}

    // Define SQL Schema; table contents
    public static class DBEntry implements BaseColumns {
        public static final String TABLE_NAME = "launch";
        public static final String COLUMN_NAME_LAUNCH = "name";
        public static final String COLUMN_NET_LAUNCH = "net";
    }
}
