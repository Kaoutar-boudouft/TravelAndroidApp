package com.example.goodtravel;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Slideradapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public Slideradapter(Context context){
        this.context=context;
    }
    public int[] slideimages={
        R.drawable.destination,
    R.drawable.ballon,
    R.drawable.computer
    };
    public String[] slideTitle={
            "Select Destination",
            "Enjoy Various Activities",
            "Book Online Now"
    };
    public String[] slideparagraph={
            "Get best deals on domestic holiday packages in Our App, Select Destination Hotels is one of the emerging travel company offering best and reasonable honeymoon tour packages. ",
            "Engaging in social and productive activities you enjoy, like taking an art class or becoming a volunteer in your community, may help to maintain your well-being.",
            "Explore the world with GOODTRAVEL Big savings on homes, hotels, flights, car rentals, taxis, and attractions – build your perfect trip on any budget."
    };


    @Override
    public int getCount() {
        return slideimages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
View view=layoutInflater.inflate(R.layout.slide,container,false);
        ImageView im=(ImageView) view.findViewById(R.id.slideimage);
        TextView title=(TextView) view.findViewById(R.id.titleslide) ;
        TextView paragraph=(TextView) view.findViewById(R.id.parag) ;
        im.setImageResource(slideimages[position]);
        title.setText(slideTitle[position]);
        paragraph.setText(slideparagraph[position]);



        container.addView(view);
return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }


}

