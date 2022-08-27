package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Home1 extends AppCompatActivity {
ImageView plane,profilepic;
CardView trips,travels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        plane=findViewById(R.id.plane);
        trips=findViewById(R.id.tripscard);
        travels=findViewById(R.id.travelscard);
        profilepic=findViewById(R.id.profilepicrestour);
        Animate(plane);

        Picasso.get().load(globalvariable.profilepic).into(profilepic);

        travels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent travelsint=new Intent(getApplicationContext(),travels.class);
                travelsint.putExtra("user",globalvariable.user);
                startActivity(travelsint);
                Log.d("tst","tst");



            }
        });
        trips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tripsint=new Intent(getApplicationContext(),Tours.class);
                tripsint.putExtra("user",globalvariable.user);
                startActivity(tripsint);


            }
        });


    }

    public void Animate(View im){
        Thread th1=new Thread(){
            @Override
            public void run() {
                while (!interrupted()){

                    try {
                        //had runOn.. ila briti t3ml chi changement f layout
                        runOnUiThread(new Runnable() {

                            @Override

                            public void run() {

                                ObjectAnimator.ofFloat(im,"translationY",0,-50,0).setDuration(4000).start();
                                ObjectAnimator.ofFloat(im,"translationX",0,-50,0).setDuration(4000).start();


                            }

                        });
                        sleep(4000);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        th1.start();
    }}