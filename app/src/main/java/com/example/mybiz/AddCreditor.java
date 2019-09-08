package com.example.mybiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCreditor extends AppCompatActivity {

//    ActionBar actionBar;
    EditText name,phone,amount,date;
    Context context = this;
    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_creditor);

        Intent secondIntent = getIntent();

//        actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000080")));

//        name = findViewById(R.id.add_name);
//        phone = findViewById(R.id.add_phone);
//        amount = findViewById(R.id.add_amount);
//        date = findViewById(R.id.add_date);

    }


    public void addCreditor(View view) {

        String creditorname     = name.getText().toString();
        String creditorphone    = phone.getText().toString();
        String creditoramount   = amount.getText().toString();
        String creditordate     = amount.getText().toString();

        dBhelper    = new DBhelper(context);
        sqLiteDatabase  = dBhelper.getWritableDatabase();

        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        dBhelper.close();

    }



}
