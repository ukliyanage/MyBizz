package com.example.mybiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="MYBIZ.DB";
    private static final int DATABSE_VERSION=1;

    private static final String CREATE_QUERY=
            "CREATE TABLE "+ Income.NewIncomeInfo.TABLE_NAME+"("+
                    Income.NewIncomeInfo.INCOME_SOURCE+" TEXT,"+
                    Income.NewIncomeInfo.INCOME_DATE+" TEXT,"+
                    Income.NewIncomeInfo.INCOME_AMOUNT+" TEXT);";


    public DBhelper (Context context){
        super(context,DATABASE_NAME,null,DATABSE_VERSION);
        Log.e("DATABASE_OPERATIONS","Database created / opened...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_QUERY);
            Log.e("DATABASE_OPERATIONS","Table created...");

    }

    public void addIncomeInfo(String source,String date, String amount,SQLiteDatabase db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(Income.NewIncomeInfo.INCOME_SOURCE,date);
        contentValues.put(Income.NewIncomeInfo.INCOME_DATE,source);
        contentValues.put(Income.NewIncomeInfo.INCOME_AMOUNT,amount);
        db.insert(Income.NewIncomeInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE_OPERATIONS","One row is inserted...");
    }

    public Cursor getInformations(SQLiteDatabase db){
        Cursor cursor;
        String[] projections={Income.NewIncomeInfo.INCOME_SOURCE,
                Income.NewIncomeInfo.INCOME_DATE,
                Income.NewIncomeInfo.INCOME_AMOUNT };
        cursor=db.query(Income.NewIncomeInfo.TABLE_NAME,projections,null,null,
                null,null,null);
        return cursor;
    }

    public Cursor getIncome(String income_source,SQLiteDatabase sqLiteDatabase){
        String[] projections = {Income.NewIncomeInfo.INCOME_DATE, Income.NewIncomeInfo.INCOME_AMOUNT};
        String selection = Income.NewIncomeInfo.INCOME_SOURCE+" LIKE ?";
        String[] selection_args = {income_source};
        Cursor cursor=sqLiteDatabase.query(Income.NewIncomeInfo.TABLE_NAME,projections,selection,selection_args,null,null,null);
        return cursor;
    }

    public void deleteIncome(String income_source,SQLiteDatabase sqLiteDatabase){
        String selection = Income.NewIncomeInfo.INCOME_SOURCE+" LIKE ?";
        String[] selection_args = {income_source};
        sqLiteDatabase.delete(Income.NewIncomeInfo.TABLE_NAME,selection,selection_args);

    }

    public int updateIncomeInformation(String old_source, String new_source, String new_date, String new_amount,
                                        SQLiteDatabase sqLiteDatabase){
                ContentValues contentValues = new ContentValues();
                contentValues.put(Income.NewIncomeInfo.INCOME_SOURCE,new_source);
                contentValues.put(Income.NewIncomeInfo.INCOME_DATE,new_date);
                contentValues.put(Income.NewIncomeInfo.INCOME_AMOUNT,new_amount);
                String selection = Income.NewIncomeInfo.INCOME_SOURCE + " LIKE ?";
                String[] selection_args = {old_source};
                int count=sqLiteDatabase.update(Income.NewIncomeInfo.TABLE_NAME,contentValues,selection,selection_args);
                return count;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
