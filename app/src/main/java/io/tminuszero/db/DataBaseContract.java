package io.tminuszero.db;

import android.provider.BaseColumns;

public final class DataBaseContract {

    // Prevent someone form accidentally instantiating the contract class
    private DataBaseContract() {}

    // Define SQL Schema; table contents
    // IF YOU EDIT SCHEMA, UPDATE DataBaseHelper DATABASE_VERSION VALUE
    public static class DBEntry implements BaseColumns {

        // Global Table Values
        // This will be shared
        // TODO: Initialize the correct values

        // Table for launch
        public static final String TABLE_NAME = "launch";
        public static final String COLUMN_NAME_LAUNCH = "name";
        public static final String COLUMN_NET_LAUNCH = "net";

        public static final String COLUMN_TBDTIME_LAUNCH = "TBDTime";
        public static final String COLUMN_TBDDATE_LAUNCH = "TBDDate";
        public static final String COLUMN_PROBABILITY_LAUNCH = "probability";

        // Table for FlightStatus
        public static final String FLIGHT_STATUS_TABLE = "flightStatus";
        public static final String COLUMN_HOLD_REASON_FLIGHT_STATUS = "holdReason";
        public static final String COLUMN_FAIL_REASON_FLIGHT_STATUS = "failReason";

        // Table for Media
        public static final String MEDIA_TABLE = "media";
        public static final String COLUMN_HASH_TAG_MEDIA = "hashTag";

        // Table for Media video URLs
        public static final String MEDIA_VIDEO_TABLE = "mediaVideo";
        public static final String COLUMN_VIDEO_URL_MEDIA = "vidURLS";

        // Table for Media info URLs
        public static final String MEDIA_INFO_TABLE = "mediaInfo";
        public static final String COLUMN_INFO_URL_MEDIA = "infoURLs";

        // Table for Location
        public static final String LOCATION_TABLE = "location";
        public static final String COLUMN_NAME_LOCATION = "name";
        public static final String COLUMN_COUNTRY_CODE_LOCATION = "countryCode";

        // Table for Pads
        public static final String PADS_TABLE = "pads";
        public static final String COLUMN_NAME_PADS = "name";
        public static final String COLUMN_WIKI_URL_PADS = "wikiURL";
        public static final String COLUMN_MAP_URL_PADS = "mapURL";
        public static final String COLUMN_LATITUDE_PADS = "latitude";
        public static final String COLUMN_LONGITUDE_PADS = "longitude";

        // Table for Rocket
        public static final String ROCKET_TABLE = "rocket";
        public static final String COLUMN_CONFIGURATION_ROCKET = "configuration";
        public static final String COLUMN_FAMILY_ROCKET = "family";
        public static final String COLUMN_WIKI_URL_ROCKET = "wikiURL";

        // Table for Rocket info URLs
        public static final String ROCKET_INFO_TABLE = "rocketInfo";
        public static final String COLUMN_INFO_URLS_ROCKET = "infoURLs";

        // Table for Rocket image sizes
        public static final String ROCKET_IMAGE_SIZE_TABLE = "rocketImage";
        public static final String COLUMN_IMAGE_SIZE_ROCKET = "imageSizes";

        // Table for Mission
        public static final String MISSION_TABLE = "mission";
        public static final String COLUMN_NAME_MISSION = "name";
        public static final String COLUMN_DESCRIPTION_MISSION = "description";
        public static final String COLUMN_TYPE_NAME_MISSION = "typeName";

        // Table for Agencies
        public static final String AGENCIES_TABLE = "agencies";
        public static final String COLUMN_NAME_AGENCIES = "name";
        public static final String COLUMN_ABBREV_AGENCIES = "abbrev";
        public static final String COLUMN_COUNTRY_CODE_AGENCIES = "countryCode";
        public static final String COLUMN_WIKI_URL_AGENCIES = "wikiURL";

        // Table for Agencies info URLs
        public static final String AGENCIES_INFO_TABLE = "agenciesInfo";
        public static final String COLUMN_INFO_URLS_AGENCIES = "infoURLs";

        // Table for LSP
        public static final String LSP_TABLE = "LSP";
        public static final String COLUMN_NAME_LSP = "name";
        public static final String COLUMN_ABBREV_LSP = "abbrev";
        public static final String COLUMN_COUNTRY_CODE = "countryCode";
        public static final String COLUMN_WIKI_URL = "wikiURL";
    }
}
