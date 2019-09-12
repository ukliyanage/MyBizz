package com.example.mybiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.WidgetContainer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void viewCreditors(View view){
        Intent intent = new Intent(this,ListCreditors.class);
        startActivity(intent);
    }


    public void searchCreditors(View view){
        Intent intent = new Intent(this,SearchCreditor.class);
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
