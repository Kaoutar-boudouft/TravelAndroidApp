package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;

public class Signin extends AppCompatActivity {
EditText bd,username,email,pass;
DatePickerDialog.OnDateSetListener setListener;
ImageView back;
String usern,mail,password,birthdate;
Button signin;
//ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        bd=findViewById(R.id.birthdatesign);
        username=findViewById(R.id.usernamesign);
        email=findViewById(R.id.emailsign);
        pass=findViewById(R.id.passwordsign);
        back=findViewById(R.id.signinback);
        signin=findViewById(R.id.signin);
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
       // im=findViewById(R.id.background);
       // animatebackgrounds.Animate(im,this);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainint=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainint);
                finish();
            }
        });

        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(Signin.this,android.R.style.Theme_Holo_Light_Dialog,setListener, year, month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date=year+"-"+month+"-"+dayOfMonth;
                bd.setText(date);
            }
        };

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usern=username.getText().toString();
                mail=email.getText().toString();
                password=pass.getText().toString();
                birthdate=bd.getText().toString();

                if(usern.equals("") || mail.equals("") || password.equals("") || birthdate.equals("")){
                    Toast.makeText(getApplicationContext(),"Vous devez Remplir tout les champs!!",Toast.LENGTH_LONG).show();
                }
                else {
                    DBTask bdt=new DBTask(Signin.this);
                    bdt.execute(usern,mail,password,birthdate);

                }

            }
        });



    }
}