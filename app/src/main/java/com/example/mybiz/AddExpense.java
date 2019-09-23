package com.example.mybiz;

import android.app.DatePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class AddExpense extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView date;
    private EditText category;
    private EditText amount;
    Context context = this;
    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;
    private Button btn4;


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        TextView textViewN = (TextView) findViewById(R.id.dateNewest);
        textViewN.setText(currentDateString);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        date = (TextView) findViewById(R.id.dateNewest);
        category = (EditText) findViewById(R.id.editTextcategory);
        amount = (EditText) findViewById(R.id.editTextAmount1);


        btn4 = (Button) findViewById(R.id.button_save);

//        category.addTextChangedListener(ExpenseTextWatcher);
//        amount.addTextChangedListener(ExpenseTextWatcher);


        //
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(category.length()==0){
                    category.setError("Enter the category");
                }
                else if(amount.length()==0){
                    amount.setError("Enter amount");
                }
                else if(date.getText()==""){
                    date.setError("enter date");
                }
                else{
                    String date1= date.getText().toString();
                    String category1=category.getText().toString();
                    String amount1=amount.getText().toString();
                    dBhelper=new DBhelper(context);
                    sqLiteDatabase=dBhelper.getWritableDatabase();
                    dBhelper.addExpenses(date1,category1,amount1,sqLiteDatabase);
                    Toast.makeText(getBaseContext(),"Expense Saved",Toast.LENGTH_LONG).show();
                    dBhelper.close();
                }
            }
        });

        //

        Button buttonE = (Button) findViewById(R.id.pickBtn);
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

    }

//    private TextWatcher ExpenseTextWatcher = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int count, int after) {
//                String categoryInputEx = category.getText().toString().trim();
//                String amountInputEx = amount.getText().toString().trim();
//
//                btn4.setEnabled(!categoryInputEx.isEmpty() && !amountInputEx.isEmpty());
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//    };

//-----------------------------------------------------------
//        Button buttonE=(Button) findViewById(R.id.pickBtn);
//        buttonE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DialogFragment datePicker =new DatePickerFragment();
//                datePicker.show(getSupportFragmentManager(),"date picker");
//            }
//        });
//
//    }




    public void addExpense(View view){
        String date1= date.getText().toString();
        String category1=category.getText().toString();
        String amount1=amount.getText().toString();
        dBhelper=new DBhelper(context);
        sqLiteDatabase=dBhelper.getWritableDatabase();
        dBhelper.addExpenses(date1,category1,amount1,sqLiteDatabase);
      //  Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        dBhelper.close();
    }
}
