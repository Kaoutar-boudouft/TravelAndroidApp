package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    TextView g,t,ood,ravel;
    LinearLayout khat,khat1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        g=findViewById(R.id.g);
        t=findViewById(R.id.t);
        ood=findViewById(R.id.ood);
        ravel=findViewById(R.id.ravel);
        khat=findViewById(R.id.khat);
        khat1=findViewById(R.id.khat1);


        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(g,"translationX",-500,0,-350),
                ObjectAnimator.ofFloat(t,"translationX",500,0,350),
                ObjectAnimator.ofFloat(ood,"translationY",-500,177),
                ObjectAnimator.ofFloat(ood,"alpha",0,0,0,0,1),
                ObjectAnimator.ofFloat(ravel,"translationY",-500,177),
                ObjectAnimator.ofFloat(ravel,"alpha",0,0,0,0,1),
                ObjectAnimator.ofFloat(g,"alpha",0,0.5f,1),
                ObjectAnimator.ofFloat(t,"alpha",0,0.5f,1),
                ObjectAnimator.ofFloat(khat,"translationX",-10000,0),
                ObjectAnimator.ofFloat(khat1,"translationX",10000,0)


                );
        animatorSet.setDuration(8000);
        animatorSet.start();
        tache1();



    }
    public void tache1(){
        Thread th1=new Thread(){
            @Override
            public void run() {


                    try {
                        sleep(9500);
                        //had runOn.. ila briti t3ml chi changement f layout
                        runOnUiThread(new Runnable() {

                            @Override

                            public void run() {
                                Intent presentation=new Intent(getApplicationContext(),Introduce.class);
                                startActivity(presentation);
                                finish();


                            }

                        });


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

        };
        th1.start();
    }
}