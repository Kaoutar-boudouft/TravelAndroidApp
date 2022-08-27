package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ReservationTour extends AppCompatActivity {

    TextView cat,titre,dd,price,pricetopay;
    EditText nbrplace;
    Button nextt;
    ImageView profilepic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_tour);
        cat=findViewById(R.id.cat);
        titre=findViewById(R.id.cattitle);
        dd=findViewById(R.id.tdd);
        price=findViewById(R.id.tp);
        nbrplace=findViewById(R.id.tnp);
        nextt=findViewById(R.id.tnextr);
        profilepic=findViewById(R.id.profilepicrestour);
        Picasso.get().load(globalvariable.profilepic).into(profilepic);

        String idtv=getIntent().getExtras().getString("idtour");
        String catv=getIntent().getExtras().getString("cate");
        String titrev=getIntent().getExtras().getString("title");
        String ddv=getIntent().getExtras().getString("dd");
        String pricev=getIntent().getExtras().getString("prix");
        String capacitev=getIntent().getExtras().getString("capacite");

        cat.setText(catv);
        titre.setText(titrev);
        dd.setText(ddv);
        price.setText(pricev+" DH");

      /*  nbrplace.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                pricetopay.setText(String.valueOf((Integer.parseInt(pricev)+((Integer.parseInt(nbrplace.getText().toString())-3)*Integer.parseInt(pricev)*0.12))));
                return false;
            }
        });*/

        nextt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                opendialogue(pricev,idtv,nbrplace.getText().toString());

              /*  if(nbrplace.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"vous devez precisez le nombre de place!!",Toast.LENGTH_LONG).show();
                }
                else{
                    int placesnumber=Integer.parseInt( nbrplace.getText().toString());
                    int capacite=Integer.parseInt(capacitev);
                    if(placesnumber>capacite){
                        Toast.makeText(getApplicationContext(),"le nombre de place est plus que le possible!!",Toast.LENGTH_LONG).show();
                    }

                    else{
                        globalvariable.typeres="Tour";
                        Intent intpay=new Intent(getApplicationContext(),payment.class);
                        intpay.putExtra("type","Tour");
                        intpay.putExtra("idtour",idtv);
                        intpay.putExtra("nbrpla",nbrplace.getText().toString());
                        startActivity(intpay);
                    }
                }*/



            }
        });

    }
    public void opendialogue(String pricev,String idtv,String nbrplacee){
        dialoguebox paydia=new dialoguebox("Price To Pay",String.valueOf((Integer.parseInt(pricev)+((Integer.parseInt(nbrplacee)-3)*Integer.parseInt(pricev)*0.12))),idtv,nbrplacee);
        paydia.show(getSupportFragmentManager(),"payement");
    }
}