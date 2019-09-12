package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class SearchIncomeActivity extends AppCompatActivity {

    TextView Display_date,Display_amount;
    EditText Search_source;
    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;
    String search_source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_income);

        Search_source=(EditText)findViewById(R.id.search_source);
        Display_date=(TextView)findViewById(R.id.display_date);
        Display_amount=(TextView)findViewById(R.id.display_amount);
        Display_amount.setVisibility(View.GONE);
        Display_date.setVisibility(View.GONE);

    }

    public void searchIncome(View view){
        search_source = Search_source.getText().toString();
        dBhelper = new DBhelper(getApplicationContext());
        sqLiteDatabase = dBhelper.getReadableDatabase();
        Cursor cursor = dBhelper.getIncome(search_source,sqLiteDatabase);
        if (cursor.moveToFirst()){
            String DATE = cursor.getString(0);
            String AMOUNT = cursor.getString(1);

            Display_date.setText(DATE);
            Display_amount.setText(AMOUNT);
            Display_amount.setVisibility(View.VISIBLE);
            Display_date.setVisibility(View.VISIBLE);
        }
    }

    public void backToHome(View view){
        Intent intent=new Intent(this,IncomeMainActivity.class);
        startActivity(intent);
    }

    public void searchIncomeControls(View view){
        Search_source.setText("");
        Display_date.setText("");
        Display_amount.setText("");


    }

    public void deleteIncome(View view){
        dBhelper = new DBhelper(getApplicationContext());
        sqLiteDatabase = dBhelper.getReadableDatabase();
        dBhelper.deleteIncome(search_source,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),"Income deleted",Toast.LENGTH_LONG).show();
    }
}
