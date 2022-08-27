package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Reservation extends AppCompatActivity {
EditText vdr,var,ddr,dar,or,pnr;
Button next;
ImageView profilepic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        vdr=findViewById(R.id.cat);
        var=findViewById(R.id.var);
        ddr=findViewById(R.id.ddr);
        dar=findViewById(R.id.tdd);
        or=findViewById(R.id.or);
        pnr=findViewById(R.id.pnr);
        next=findViewById(R.id.tnextr);
        profilepic=findViewById(R.id.profilepicrestour);
        Picasso.get().load(globalvariable.profilepic).into(profilepic);



        String idr=getIntent().getExtras().getString("idr");
        String vdrv=getIntent().getExtras().getString("vdr");
        String varv=getIntent().getExtras().getString("var");
        String ddrv=getIntent().getExtras().getString("ddr");
        String darv=getIntent().getExtras().getString("dar");
        String hdrv=getIntent().getExtras().getString("hdr");
        String harv=getIntent().getExtras().getString("har");
        String orv=getIntent().getExtras().getString("or");
        String cr=getIntent().getExtras().getString("cr");

        vdr.setText(vdrv);
        var.setText(varv);
        ddr.setText(ddrv+" "+hdrv);
        dar.setText(darv+" "+harv);
        pnr.setHint(cr+" au maximum");
        or.setText(orv);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pnr.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"vous devez precisez le nombre de place!!",Toast.LENGTH_LONG).show();
                }
                else{
                    int placesnumber=Integer.parseInt( pnr.getText().toString());
                    int capacite=Integer.parseInt(cr);
                    if(placesnumber>capacite){
                        Toast.makeText(getApplicationContext(),"le nombre de place est plus que le possible!!",Toast.LENGTH_LONG).show();
                    }

                    else{
                        globalvariable.typeres="voyage";
                        Intent intpay=new Intent(getApplicationContext(),payment.class);
                        intpay.putExtra("idr",idr);
                        intpay.putExtra("vdr",vdrv);
                        intpay.putExtra("var",varv);
                        intpay.putExtra("ddr",ddrv);
                        intpay.putExtra("dar",darv);
                        intpay.putExtra("hdr",hdrv);
                        intpay.putExtra("har",harv);
                        intpay.putExtra("or",orv);
                        intpay.putExtra("nbreplace",pnr.getText().toString());
                        startActivity(intpay);
                    }
                }



            }
        });



    }
}