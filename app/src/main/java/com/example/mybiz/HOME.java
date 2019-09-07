package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HOME extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void goIncomes(View view){
        Intent intent=new Intent(this,IncomeMainActivity.class);
        startActivity(intent);
    }
}
