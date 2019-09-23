package com.example.mybiz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ExpensesListActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DBhelper dBhelper;
    Cursor cursor;
    com.example.mybiz.listExpenseAdapter listExpenseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expenses_list_layout);
        listView=(ListView)findViewById(R.id.list_view);
        listExpenseAdapter=new listExpenseAdapter(getApplicationContext(), R.layout.e_row_layout);
         listView.setAdapter(listExpenseAdapter);
        dBhelper=new DBhelper(getApplicationContext());
        sqLiteDatabase = dBhelper.getReadableDatabase();
        cursor =dBhelper.getExpenses(sqLiteDatabase);
        if(cursor.moveToFirst()){
            do{
                String date,category,amount;
                date=cursor.getString(0);
                category=cursor.getString(1);
                amount=cursor.getString(2);
                DataProviderEx dataProviderEx=new DataProviderEx(date,category,amount);
                listExpenseAdapter.add(dataProviderEx);
            }while(cursor.moveToNext());
        }
    }
}
