 package com.example.mybiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY = "CREATE TABLE "+ Creditors.NewCreditorInfo.TABLE_NAME+"("+ Creditors.NewCreditorInfo.USER_NAME+" TEXT,"+ Creditors.NewCreditorInfo.USER_PHONE+" TEXT,"+ Creditors.NewCreditorInfo.USER_AMOUNT+" TEXT," + Creditors.NewCreditorInfo.USER_DATE+" TEXT);";

    public DBhelper(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table Created...");
    }

    public void addInformation(String name, String phone, String amount, String data, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Creditors.NewCreditorInfo.USER_NAME,name);
        contentValues.put(Creditors.NewCreditorInfo.USER_PHONE,phone);
        contentValues.put(Creditors.NewCreditorInfo.USER_AMOUNT,amount);
        contentValues.put(Creditors.NewCreditorInfo.USER_DATE,data);
        db.insert(Creditors.NewCreditorInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","One Row Inserted...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
