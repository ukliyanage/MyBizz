package com.example.mybiz;

import android.app.DatePickerDialog;
import android.database.Cursor;
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

public class UpdateExpense extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView display_Title_up,display_date_up;
    EditText search_cat_up,display_amount_up,display_cat_up;

    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;
    String editText_search_up;

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        TextView textViewN=(TextView)findViewById(R.id.textViewPickDate);
        textViewN.setText(currentDateString);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_expense);

        Button btn4 = (Button) findViewById(R.id.dataPick8);


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        search_cat_up=(EditText)findViewById(R.id.update_editText);

        display_Title_up=findViewById(R.id.title_up);
        display_date_up=findViewById(R.id.textViewPickDate);
        display_cat_up=findViewById(R.id.cat_edit_up1);
        display_amount_up=findViewById(R.id.amnt4);

        display_Title_up.setVisibility(View.GONE);
        display_date_up.setVisibility(View.GONE);
        display_cat_up.setVisibility(View.GONE);
        display_amount_up.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
    }

    public void updateExpenseNew1(View view){

        dBhelper = new DBhelper(getApplicationContext());
        sqLiteDatabase = dBhelper.getWritableDatabase();

        String categy_u, date_u, amnt_u ;

        categy_u = display_cat_up.getText().toString();
        date_u = display_date_up.getText().toString();
        amnt_u = display_amount_up.getText().toString();

        int count = dBhelper.updateExpenses2(editText_search_up, categy_u, date_u, amnt_u,sqLiteDatabase);

        Toast.makeText(getApplicationContext(),count+ " Expense Updated",Toast.LENGTH_LONG).show();
        finish();
    }



    public void searchExpenseInUP(View view) {
//
       editText_search_up = search_cat_up.getText().toString();
       dBhelper = new DBhelper(getApplicationContext());
       sqLiteDatabase = dBhelper.getReadableDatabase();
//
       Cursor cursor = dBhelper.getExpenSearch(editText_search_up, sqLiteDatabase);
//
       if (cursor.moveToFirst()) {
           String date_up = cursor.getString(0);
            String amount_up=cursor.getString(1);
            String newCat_up=editText_search_up;

           display_date_up.setText(date_up);
           display_amount_up.setText(amount_up);
           display_cat_up.setText(newCat_up);

//
           Button btn4=findViewById(R.id.dataPick8);
           display_Title_up.setVisibility(View.VISIBLE);
           display_date_up.setVisibility(View.VISIBLE);
           display_cat_up.setVisibility(View.VISIBLE);
           display_amount_up.setVisibility((View.VISIBLE ));
           btn4.setVisibility(View.VISIBLE);

       }


   }


}
