package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddIncome extends AppCompatActivity {
    EditText IncomeDate,IncomeSource,IncomeAmount;
    Context context=this;
    DBhelper userDBHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        IncomeSource=(EditText)findViewById(R.id.add_income_source);
        IncomeDate=(EditText)findViewById(R.id.add_income_date);
        IncomeAmount=(EditText)findViewById(R.id.add_income_amount);
    }

    public void addIncome(View view){
        String date=IncomeDate.getText().toString();
        String source=IncomeSource.getText().toString();
        String amount=IncomeAmount.getText().toString();
        userDBHelper=new DBhelper(context);
        sqLiteDatabase=userDBHelper.getWritableDatabase();
        userDBHelper.addIncomeInfo(date,source,amount,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        userDBHelper.close();
    }

    public void clearContols(View view){
        IncomeSource.setText("");
        IncomeDate.setText("");
        IncomeAmount.setText("");
    }

}
