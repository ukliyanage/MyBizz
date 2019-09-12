package com.example.mybiz;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCreditor extends AppCompatActivity {

    EditText name,phone,amount,date;
    Context context = this;
    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_creditor);

        Intent secondIntent = getIntent();

        name    = findViewById(R.id.add_namec);
        phone   = findViewById(R.id.add_phonec);
        amount  = findViewById(R.id.add_amountc);
        date    = findViewById(R.id.add_datec);

    }


    public void addCreditor(View view) {

        String cname     = name.getText().toString();
        String cphone    = phone.getText().toString();
        String camount   = amount.getText().toString();
        String cdate     = date.getText().toString();

        dBhelper         = new DBhelper(context);
        sqLiteDatabase  = dBhelper.getWritableDatabase();

        dBhelper.addCreditorInfo(cname,cphone,camount,cdate,sqLiteDatabase);

        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();

        dBhelper.close();

    }

    public void clearAll(View view){
        name.setText("");
        phone.setText("");
        amount.setText("");
        date.setText("");
    }



}
