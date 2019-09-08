package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DebitorHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debitor_home);
    }


    public void pressAdd(View view){
        Intent intent = new Intent(this,AddDebitor.class);
        startActivity(intent);

    }
}
