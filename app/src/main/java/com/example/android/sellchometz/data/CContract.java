package com.example.android.sellchometz.data;

import android.provider.BaseColumns;

/**
 * Created by Home on 5/7/2017.
 */

public  final class CContract {

    private CContract() {
    }

    public static final class CEntry implements BaseColumns {

        public final static String TABLE_NAME = "info";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_SHUL_NAME ="shul";

        public final static String COLUMN_PASSWORD = "email";

        public final static String COLUMN_RABBI = "rov";

    }
}

