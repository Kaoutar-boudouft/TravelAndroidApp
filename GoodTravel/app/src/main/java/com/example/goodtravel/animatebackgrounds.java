package com.example.goodtravel;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

public class animatebackgrounds {
    public static void Animate(View im, Activity a){
        Thread th1=new Thread(){
            @Override
            public void run() {
                while (!interrupted()){

                    try {
                        //had runOn.. ila briti t3ml chi changement f layout
                        a.runOnUiThread(new Runnable() {

                            @Override

                            public void run() {

                                ObjectAnimator.ofFloat(im,"translationY",0,-50,0).setDuration(5000).start();


                            }

                        });
                        sleep(4500);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        th1.start();
    }
}
