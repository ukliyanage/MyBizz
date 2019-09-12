package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityUpdateIncome extends AppCompatActivity {

    EditText Source_Search,New_Income_Source,New_Income_Date,New_income_Amount;
    TextView title_text;
    ImageView Update_income_btn;
    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;
    String SearchIncomeSource,NewIncomeSource,NewIncomeDate,NewIncomeAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_income);

        Source_Search=(EditText)findViewById(R.id.update_source);

        New_Income_Source=(EditText) findViewById(R.id.update_income_source);
        New_Income_Date=(EditText)findViewById(R.id.update_income_date);
        New_income_Amount=(EditText)findViewById(R.id.update_income_amount);

        Update_income_btn=(ImageView)findViewById(R.id.btn_update) ;
        title_text=(TextView)findViewById(R.id.txt_update_income);

        New_Income_Source.setVisibility(View.GONE);
        New_Income_Date.setVisibility(View.GONE);
        New_income_Amount.setVisibility(View.GONE);

        title_text.setVisibility(View.GONE);

    }

    public void searchIncome(View view){
        SearchIncomeSource = Source_Search.getText().toString();
        dBhelper = new DBhelper(getApplicationContext());
        sqLiteDatabase = dBhelper.getReadableDatabase();
        Cursor cursor = dBhelper.getIncome(SearchIncomeSource,sqLiteDatabase);
        if (cursor.moveToFirst()){
            NewIncomeDate = cursor.getString(0);
            NewIncomeAmount = cursor.getString(1);

            NewIncomeSource=SearchIncomeSource;
            New_Income_Source.setText(NewIncomeSource);
            New_Income_Date.setText(NewIncomeDate);
            New_income_Amount.setText(NewIncomeAmount);

            New_Income_Source.setVisibility(View.VISIBLE);
            New_Income_Date.setVisibility(View.VISIBLE);
            New_income_Amount.setVisibility(View.VISIBLE);
            Update_income_btn.setVisibility(View.VISIBLE);
            title_text.setVisibility(View.VISIBLE);

        }
    }

    public void updateIncome(View view){
        dBhelper= new DBhelper(getApplicationContext());
        sqLiteDatabase=dBhelper.getWritableDatabase();
        String income_source,income_date,income_amount;
            income_source = New_Income_Source.getText().toString();
            income_date = New_Income_Date.getText().toString();
            income_amount = New_income_Amount.getText().toString();
           int count= dBhelper.updateIncomeInformation(SearchIncomeSource,
                    income_source,income_date,income_amount,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),count+" updated",Toast.LENGTH_LONG).show();
        finish();
    }

    public void backToHome(View view){
        Intent intent=new Intent(this,IncomeMainActivity.class);
        startActivity(intent);
    }

    public void searchIncomeControls(View view){
        New_Income_Source.setText("");
        New_Income_Date.setText("");
        New_income_Amount.setText("");


    }


}
