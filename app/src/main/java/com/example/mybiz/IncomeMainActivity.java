package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IncomeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_main);
    }

    public void addIncomes(View view){
        Intent intent=new Intent(this,ActivityAddIncome.class);
        startActivity(intent);
    }

    public void viewIncome(View view){
        Intent intent=new Intent(this,ViewIncomeActivity.class);
        startActivity(intent);
    }

    public void searchIncome(View view){
        Intent intent=new Intent(this,SearchIncomeActivity.class);
        startActivity(intent);
    }

    public void updateIncome(View view){
        Intent intent=new Intent(this,ActivityUpdateIncome.class);
        startActivity(intent);
    }



}
