package com.example.mybiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void pressAdd(View view){
        Intent intent = new Intent(this, AddCreditor.class);
        startActivity(intent);

    }

    public void viewCreditors(View view){
        Intent intent = new Intent(this, ListCreditors.class);
        startActivity(intent);
    }


    public void searchCreditors(View view){
        Intent intent = new Intent(this, SearchCreditor.class);
        startActivity(intent);
    }

    public void dltCreditors(View view) {
        Intent intent = new Intent(this, SearchCreditor.class);
        startActivity(intent);
    }

    public void updtCreditors(View view) {
        Intent intent = new Intent(this, UpdateCreditors.class);
        startActivity(intent);
    }


}
