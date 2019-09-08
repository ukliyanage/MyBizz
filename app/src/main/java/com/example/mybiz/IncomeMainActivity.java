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
        Intent intent=new Intent(this,AddIncome.class);
        startActivity(intent);
    }

//    public void goanother(View view){
//        Intent intent=new Intent(this,Main2Activity.class);
//        startActivity(intent);
//    }
}
