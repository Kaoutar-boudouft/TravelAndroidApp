package com.example.goodtravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class travels extends AppCompatActivity {
BottomNavigationView btmoutils;
ImageView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);
        String user=getIntent().getExtras().getString("user");

        //profile=findViewById(R.id.profile);
      /*  String user=getIntent().getExtras().getString("user");
        String pass=getIntent().getExtras().getString("pass");
        String pic=getIntent().getExtras().getString("picture");
        Log.d("intentres",user+"/"+pass+"/"+pic);
        Picasso.get().load(pic).into(profile);*/

        /*profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editeprofileint=new Intent(getApplicationContext(),EditeProfile.class);
                editeprofileint.putExtra("user",user);
                editeprofileint.putExtra("pass",pass);
                editeprofileint.putExtra("picture",pic);
                startActivity(editeprofileint);
            }
        });*/

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.travelbyoutilcontainer,new TravelByFlight()).commit();
        }
        btmoutils=findViewById(R.id.btmoutils);
        btmoutils.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfrag=null;
                switch (item.getItemId()){
                    case R.id.nav_flight:
                        selectedfrag=new TravelByFlight();
                        break;
                    case R.id.nav_train:
                        selectedfrag=new TravelByTrain();
                        break;
                    case R.id.nav_bus:
                        selectedfrag=new TravelByBus();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.travelbyoutilcontainer,selectedfrag).commit();
                return true;
            }
        });

    }
}