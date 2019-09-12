package com.example.mybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SearchCreditor extends AppCompatActivity {

    TextView display_phone, display_amount, display_date;
    EditText search_name;
    DBhelper dBhelper;
    SQLiteDatabase sqLiteDatabase;
    String searchname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_creditor);

        search_name = findViewById(R.id.searchtxtc);

        display_amount = findViewById(R.id.search_amount);
        display_phone  = findViewById(R.id.search_phone);
        display_date   = findViewById(R.id.search_date);

        display_phone.setVisibility(View.GONE);
        display_amount.setVisibility(View.GONE);
        display_date.setVisibility(View.GONE);
    }

    public void searchCreditor(View view) {

        searchname      = search_name.getText().toString();
        dBhelper        = new DBhelper(getApplicationContext());
        sqLiteDatabase  = dBhelper.getReadableDatabase();

        Cursor cursor   = dBhelper.getCDetails(searchname,sqLiteDatabase);

        if(cursor.moveToFirst()){
            String PHONE = cursor.getString(0);
            String AMOUNT = cursor.getString(1);
            String DATE = cursor.getString(2);

            display_phone.setText(PHONE);
            display_amount.setText(AMOUNT);
            display_date.setText(DATE);

            display_phone.setVisibility(View.VISIBLE);
            display_amount.setVisibility(View.VISIBLE);
            display_date.setVisibility(View.VISIBLE);
        }
    }

    public void backhome (View view){
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void dltcreditor(View view){

        dBhelper        = new DBhelper(getApplicationContext());
        sqLiteDatabase  = dBhelper.getReadableDatabase();

        dBhelper.deleteCreditors(searchname,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),"Creditor Deleted",Toast.LENGTH_LONG).show();
    }
}
