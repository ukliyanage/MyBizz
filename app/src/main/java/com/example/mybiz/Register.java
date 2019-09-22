package com.example.mybiz;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Register extends AppCompatActivity {

    DBhelper db;

    EditText email,password,confirm;
    CardView reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBhelper(this);

        email = findViewById(R.id.r_email);
        password = findViewById(R.id.r_password);
        confirm = findViewById(R.id.r_confirm);

        reg = findViewById(R.id.crdregister);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1 = email.getText().toString();
                String p1 = password.getText().toString();
                String c1 = confirm.getText().toString();

                if (e1.equals("")||p1.equals("")||c1.equals("")){
                    Toast.makeText(getApplicationContext(),"Your Fields are Empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (p1.equals(c1)){
                        Boolean chkemail = db.chkemail(e1);
                        if (chkemail==true){
                            Boolean insert = db.insert(e1,p1);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"Successfully Registered", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"Not Inserted",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"e-mail Already Exists!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}