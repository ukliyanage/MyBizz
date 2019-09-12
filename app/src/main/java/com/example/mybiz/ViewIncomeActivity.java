package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class ViewIncomeActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DBhelper dBhelper;
    Cursor cursor;
    ListIncomeAdapter listIncomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_income);
        listView=(ListView)findViewById(R.id.list_view);
        listIncomeAdapter=new ListIncomeAdapter(getApplicationContext(),R.layout.row_income_layout);
        listView.setAdapter(listIncomeAdapter);
        dBhelper=new DBhelper(getApplicationContext());
        sqLiteDatabase=dBhelper.getReadableDatabase();
        cursor=dBhelper.getInformations(sqLiteDatabase);

        if(cursor.moveToFirst()){
            do{
                String source,date,amount;
                source=cursor.getString(0);
                date=cursor.getString(1);
                amount=cursor.getString(2);
                IncomeProvider incomeProvider=new IncomeProvider(source,date,amount);
                listIncomeAdapter.add(incomeProvider);

            }while (cursor.moveToNext());
        }
    }
}
