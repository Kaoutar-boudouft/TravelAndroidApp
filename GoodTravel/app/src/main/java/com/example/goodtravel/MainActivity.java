package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button log,sign;
ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log=findViewById(R.id.loginbtn);
        sign=findViewById(R.id.signinbtn);
        im=findViewById(R.id.background);
        animatebackgrounds.Animate(im,this);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logint=new Intent(getApplicationContext(),Login.class);
                startActivity(logint);
                finish();
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signint=new Intent(getApplicationContext(),Signin.class);
                startActivity(signint);
                finish();
            }
        });
    }

}