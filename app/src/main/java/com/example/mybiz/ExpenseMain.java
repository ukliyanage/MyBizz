package com.example.mybiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExpenseMain extends AppCompatActivity {
private Button add1;
private Button search2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_main);

//        add1=findViewById(R.id.buttonExpense);
//
//        add1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addingExpenses();
//            }
//
//        });


//        search2=findViewById(R.id.buttonMain_search);
//
//        search2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addingExpenses();
//            }
//
//        });
//
//




    }

    public void addingExpenses(View view){

        Intent intent=new Intent(ExpenseMain.this, AddExpense.class);
        startActivity(intent);
    }

    public void viewExpenses(View view){
        Intent intent=new Intent(this,ExpensesListActivity.class);
        startActivity(intent);
    }

    public void searchExpense1(View view){
        Intent intent=new Intent(this,expense_search.class);
        startActivity(intent);
    }


    public void updateSearch1(View view){
        Intent intent=new Intent(this,UpdateExpense.class);
        startActivity(intent);
    }
}
