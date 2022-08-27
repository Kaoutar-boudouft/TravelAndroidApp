package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Introduce extends AppCompatActivity {
ViewPager vp;
Slideradapter sa;
Button skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        vp=(ViewPager) findViewById(R.id.vp);
        skip=findViewById(R.id.skip);
        sa=new Slideradapter(this);
        vp.setAdapter(sa);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intskip=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intskip);
                finish();
            }
        });

    }
}