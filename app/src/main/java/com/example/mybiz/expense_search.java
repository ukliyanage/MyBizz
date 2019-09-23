package com.example.mybiz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class expense_search extends AppCompatActivity {

    TextView display_date,display_amount;
    EditText search_cat;

    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;
    String editText_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_search);

        search_cat=(EditText)findViewById(R.id.editText_search);

        display_date=(TextView)findViewById(R.id.txt_date);
        display_amount=(TextView)findViewById(R.id.editTextAmount1);
        display_date.setVisibility(View.GONE);
        display_amount.setVisibility(View.GONE);
    }

    public void searchExpenseIn(View view){

        editText_search=search_cat.getText().toString();
        dBhelper=new DBhelper(getApplicationContext());
        sqLiteDatabase =dBhelper.getReadableDatabase();

        Cursor cursor= dBhelper.getExpenSearch(editText_search,sqLiteDatabase);

        if(cursor.moveToFirst()){
            String date1=cursor.getString(0);
            String amount1=cursor.getString(1);

            display_date.setText(date1);
            display_amount.setText(amount1);

            display_amount.setVisibility(View.VISIBLE);
            display_date.setVisibility((View.VISIBLE ));
        }

    }
    public void deleteExpense(View view){
        dBhelper=new DBhelper(getApplicationContext());
        sqLiteDatabase =dBhelper.getReadableDatabase();
        dBhelper.deleteInformation(editText_search,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),"Expense deleted",Toast.LENGTH_LONG).show();
    }

}
