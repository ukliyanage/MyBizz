 package com.example.mybiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

 public class DBhelper extends SQLiteOpenHelper {

     private static final String DATABASE_NAME = "MYBIZ.DB";
     private static final int DATABASE_VERSION = 1;
     private static final String CREATE_QUERY = "CREATE TABLE "+ Creditors.NewCreditorInfo.TABLE_NAME+"("+ Creditors.NewCreditorInfo.USER_NAME+" TEXT,"+ Creditors.NewCreditorInfo.USER_PHONE+" TEXT,"+ Creditors.NewCreditorInfo.USER_AMOUNT+" TEXT," + Creditors.NewCreditorInfo.USER_DATE+" TEXT);";
     private static final String CREATE_QUERY2="CREATE TABLE "+ ExpenseC.NewExpenseIn.table_name+"("+ ExpenseC.NewExpenseIn.date+" TEXT,"+ ExpenseC.NewExpenseIn.category+" TEXT,"+ ExpenseC.NewExpenseIn.amount+" TEXT);";
     public DBhelper(Context context) {

         super(context,DATABASE_NAME,null,DATABASE_VERSION);
         Log.e("DATABASE OPERATIONS","Database created / opened...");
     }


     @Override
     public void onCreate(SQLiteDatabase db) {

         db.execSQL(CREATE_QUERY);
         db.execSQL(CREATE_QUERY2);
         Log.e("DATABASE OPERATIONS","Table Created...");
     }

     public void addExpenses(String dte,String catgry,String amot, SQLiteDatabase db){
             ContentValues contentValues=new ContentValues();
              contentValues.put(ExpenseC.NewExpenseIn.date,dte);
             contentValues.put(ExpenseC.NewExpenseIn.category,catgry);
             contentValues.put(ExpenseC.NewExpenseIn.amount,amot);

             db.insert(ExpenseC.NewExpenseIn.table_name,null,contentValues);

         Log.e("DATABASE OPERATIONS","One Row Inserted...");

     }


     public Cursor getExpenses(SQLiteDatabase db){
         Cursor cursor;
         String[] projections={ExpenseC.NewExpenseIn.date, ExpenseC.NewExpenseIn.category, ExpenseC.NewExpenseIn.amount} ;
         cursor=db.query(ExpenseC.NewExpenseIn.table_name,projections,null,null,null,null,null);
         return cursor;
     }

     public Cursor getExpenSearch(String category,SQLiteDatabase sqLiteDatabase){
         String[] projections={ExpenseC.NewExpenseIn.date, ExpenseC.NewExpenseIn.amount};
         String selection = ExpenseC.NewExpenseIn.category+" Like ?";
         String[] selection_args={category};
         Cursor cursor=sqLiteDatabase.query(ExpenseC.NewExpenseIn.table_name,projections,selection,selection_args,null,null,null);
         return cursor;
     }

     public void deleteInformation(String category,SQLiteDatabase sqLiteDatabase){
         String selection = ExpenseC.NewExpenseIn.category+" Like ?";
         String[] selection_args={category};
         sqLiteDatabase.delete(ExpenseC.NewExpenseIn.table_name,selection,selection_args);
     }

     public int updateExpenses2(String old_cat,String new_cat_1,String new_date_1,String new_amount_1,SQLiteDatabase sqLiteDatabase){
         ContentValues contentValues= new ContentValues();
         contentValues.put(ExpenseC.NewExpenseIn.category,new_cat_1);
         contentValues.put(ExpenseC.NewExpenseIn.date,new_date_1);
         contentValues.put(ExpenseC.NewExpenseIn.amount,new_amount_1);

         String selection= ExpenseC.NewExpenseIn.category + " LIKE ?";
         String[] selection_args = {old_cat};
         int count=sqLiteDatabase.update(ExpenseC.NewExpenseIn.table_name,contentValues,selection,selection_args);
         return count;

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
