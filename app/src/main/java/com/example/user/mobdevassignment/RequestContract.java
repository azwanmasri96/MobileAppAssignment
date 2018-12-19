package com.example.user.mobdevassignment;

import android.provider.BaseColumns;

public final class RequestContract {
    public RequestContract(){}

    public static abstract class User implements BaseColumns {
        public static final String TABLE_NAME ="user";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_PROBLEM ="problem";
        public static final String COLUMN_UNIVERSITY ="university";
        public static final String COLUMN_MODEL ="model";
        public static final String COLUMN_CASE_ID ="caseID";
        public static final String COLUMN_CONDITION ="condition";
    }
}
