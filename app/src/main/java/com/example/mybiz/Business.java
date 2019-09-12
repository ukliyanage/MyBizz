package com.example.mybiz;

import android.provider.BaseColumns;

public class Business implements BaseColumns {

    public static abstract class NewCreditorInfo {

        public static final String CREDITOR_NAME = "add_name";
        public static final String CREDITOR_PHONE = "add_phone";
        public static final String CREDITOR_AMOUNT = "add_amount";
        public static final String CREDITOR_DATE = "add_date";

        public static final String TABLE_NAME = "creditor_info";

    }

}
