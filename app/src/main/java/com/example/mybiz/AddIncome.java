package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddIncome extends AppCompatActivity {
    Button buttonAdd;

    EditText IncomeDate,IncomeSource,IncomeAmount;
    Context context=this;
    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        IncomeSource=(EditText)findViewById(R.id.income_add_source);
        IncomeDate=(EditText)findViewById(R.id.income_add_date);
        IncomeAmount=(EditText)findViewById(R.id.income_add_amount);




    }

    public void addIncome(View view){
        String date=IncomeDate.getText().toString();
        String source=IncomeSource.getText().toString();
        String amount=IncomeAmount.getText().toString();
        dBhelper=new DBhelper(context);
        sqLiteDatabase=dBhelper.getWritableDatabase();
        dBhelper.addIncomeInfo(date,source,amount,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        dBhelper.close();
    }

    public void clearControls(View view){
        IncomeSource.setText("");
        IncomeDate.setText("");
        IncomeAmount.setText("");

    }


}
