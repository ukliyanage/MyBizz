 package com.example.mybiz;



import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MYBIZ.DB";
    private static final int DATABASE_VERSION = 1;


//-----------------CREDITOR TABLE-----------------
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ Business.NewCreditorInfo.TABLE_NAME+"("+
                    Business.NewCreditorInfo.CREDITOR_NAME+" TEXT,"+
                    Business.NewCreditorInfo.CREDITOR_PHONE+" TEXT,"+
                    Business.NewCreditorInfo.CREDITOR_AMOUNT+" TEXT," +
                    Business.NewCreditorInfo.CREDITOR_DATE+" TEXT);";

//-----------------INCOME TABLE--------------------
    private static final String CREATE_QUERY1=
            "CREATE TABLE "+ Income.NewIncomeInfo.TABLE_NAME+"("+
                    Income.NewIncomeInfo.INCOME_SOURCE+" TEXT,"+
                    Income.NewIncomeInfo.INCOME_DATE+" TEXT,"+
                    Income.NewIncomeInfo.INCOME_AMOUNT+" TEXT);";

    public DBhelper(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created / opened...");
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Creditor Table Created...");

        db.execSQL(CREATE_QUERY1);
        Log.e("DATABASE OPERATIONS","Income Table Created...");
    }

//---------------------add income-----------------

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



    //---------------add creditor----------------------

    public void addCreditorInfo(String name, String phone, String amount, String date, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();

        contentValues.put(Business.NewCreditorInfo.CREDITOR_NAME,name);
        contentValues.put(Business.NewCreditorInfo.CREDITOR_PHONE,phone);
        contentValues.put(Business.NewCreditorInfo.CREDITOR_AMOUNT,amount);
        contentValues.put(Business.NewCreditorInfo.CREDITOR_DATE,date);

        db.insert(Business.NewCreditorInfo.TABLE_NAME,null,contentValues);

        Log.e("DATABASE_OPERATIONS","One row is inserted...");
    }


    //-----------getData--------------------

    public Cursor getCreditors(SQLiteDatabase db) {

        Cursor cursor;

        String[] cprojectios = {Business.NewCreditorInfo.CREDITOR_NAME,Business.NewCreditorInfo.CREDITOR_PHONE,Business.NewCreditorInfo.CREDITOR_AMOUNT,Business.NewCreditorInfo.CREDITOR_DATE};
        cursor = db.query(Business.NewCreditorInfo.TABLE_NAME,cprojectios,null,null,null,null,null);

        return cursor;
    }



    public Cursor getCDetails(String c_name, SQLiteDatabase sqLiteDatabase){

        String[] cprojections2 = {Business.NewCreditorInfo.CREDITOR_PHONE,Business.NewCreditorInfo.CREDITOR_AMOUNT,Business.NewCreditorInfo.CREDITOR_DATE};
        String selection = Business.NewCreditorInfo.CREDITOR_NAME+" LIKE ?";
        String[] selectionc_args = {c_name};

        Cursor cursor = sqLiteDatabase.query(Business.NewCreditorInfo.TABLE_NAME, cprojections2, selection,selectionc_args,null,null,null);

        return cursor;
    }


    public void deleteCreditors(String search_name, SQLiteDatabase sqLiteDatabase){

        String selection = Business.NewCreditorInfo.CREDITOR_NAME+" LIKE ?";
        String[] selectionc_args = {search_name};

        sqLiteDatabase.delete(Business.NewCreditorInfo.TABLE_NAME,selection,selectionc_args);
    }


    public int updateCreditors(String old_name,String new_name, String new_phone, String new_amount, String new_date, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(Business.NewCreditorInfo.CREDITOR_NAME, new_name);
        contentValues.put(Business.NewCreditorInfo.CREDITOR_PHONE, new_phone);
        contentValues.put(Business.NewCreditorInfo.CREDITOR_AMOUNT, new_amount);
        contentValues.put(Business.NewCreditorInfo.CREDITOR_DATE, new_date);

        String selection = Business.NewCreditorInfo.CREDITOR_NAME + " LIKE ?";
        String[] selection_args = {old_name};

        int count = sqLiteDatabase.update(Business.NewCreditorInfo.TABLE_NAME,contentValues,selection,selection_args);

        return count;

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
