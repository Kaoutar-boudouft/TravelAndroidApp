package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class payment extends AppCompatActivity {
Spinner expyp,expmp;
EditText usep,cnp,chnp,cryp;
Button payer;
ImageView profilepic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        expyp=findViewById(R.id.expys);
        expmp=findViewById(R.id.expms);
        usep=findViewById(R.id.usep);
        cnp=findViewById(R.id.cnp);
        chnp=findViewById(R.id.chnp);
        cryp=findViewById(R.id.cryp);
        payer=findViewById(R.id.payer);
        profilepic=findViewById(R.id.profilepicrestour);

        Picasso.get().load(globalvariable.profilepic).into(profilepic);

        String [] tabyers={"2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,tabyers);
        expyp.setAdapter(adapter);

        String [] tabmonths={"1","2","3","4","5","6","7","8","9","10","11","12"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,tabmonths);
        expmp.setAdapter(adapter1);

        if(globalvariable.typeres.equals("voyage")){
            String idr=getIntent().getExtras().getString("idr");



            String vdrv=getIntent().getExtras().getString("vdr");
            String varv=getIntent().getExtras().getString("var");
            String ddrv=getIntent().getExtras().getString("ddr");
            String darv=getIntent().getExtras().getString("dar");
            String hdrv=getIntent().getExtras().getString("hdr");
            String harv=getIntent().getExtras().getString("har");
            String orv=getIntent().getExtras().getString("or");
            String placesnumber=getIntent().getExtras().getString("nbreplace");

            payer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cnpp=cnp.getText().toString();
                    String chnpp=chnp.getText().toString();
                    String crypp=cryp.getText().toString();
                    int yearexpindex=expyp.getSelectedItemPosition();
                    String yearexp=expyp.getItemAtPosition(yearexpindex).toString();
                    int monthexpindex=expmp.getSelectedItemPosition();
                    String monthexp=expmp.getItemAtPosition(monthexpindex).toString();

                    if(cnpp.equals("") || chnpp.equals("") || crypp.equals("")){
                        Toast.makeText(getApplicationContext(),"vous devez remplir tous les chaùps!!",Toast.LENGTH_LONG).show();
                    }
                    else {
                        String url="http://"+globalvariable.ip+"/GoodTravelAppApi/cardcheck.php";
                        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                String res=response.trim();
                                if (res.equals("valide")){
                                    String payurl="http://"+globalvariable.ip+"/GoodTravelAppApi/payement.php";
                                    StringRequest stringRequest1=new StringRequest(Request.Method.POST, payurl, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            opendialogue();

                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {

                                        }
                                    }){
                                        @Override
                                        protected Map<String, String> getParams(){
                                            Map<String,String> params1=new HashMap<String,String>();
                                            params1.put("user",globalvariable.user);
                                            params1.put("type","voyage");
                                            params1.put("id",idr);
                                            params1.put("nbplace",placesnumber);

                                            return params1;
                                        }
                                    };
                                    RequestQueue requestQueue1=Volley.newRequestQueue(getApplicationContext());
                                    requestQueue1.add(stringRequest1);

                                }

                                Toast.makeText(getApplicationContext(), response.trim(), Toast.LENGTH_LONG).show();

                            }
                        },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }

                        ){

                            @Override
                            protected Map<String, String> getParams() {
                                Map<String,String> params=new HashMap<String,String>();
                                params.put("cardnumber",cnpp);
                                params.put("cardholder",chnpp);
                                params.put("crypto",crypp);
                                params.put("expyear",yearexp);
                                params.put("expmonth",monthexp);

                                return params;

                            }
                        };
                        RequestQueue requestQueue=Volley.newRequestQueue(payment.this);
                        requestQueue.add(stringRequest);
                    }
                }
            });

        }

        else {
            String idt = getIntent().getExtras().getString("idtour");
            String nbrp = getIntent().getExtras().getString("nbrpla");


            payer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cnpp = cnp.getText().toString();
                    String chnpp = chnp.getText().toString();
                    String crypp = cryp.getText().toString();
                    int yearexpindex = expyp.getSelectedItemPosition();
                    String yearexp = expyp.getItemAtPosition(yearexpindex).toString();
                    int monthexpindex = expmp.getSelectedItemPosition();
                    String monthexp = expmp.getItemAtPosition(monthexpindex).toString();

                    if (cnpp.equals("") || chnpp.equals("") || crypp.equals("")) {
                        Toast.makeText(getApplicationContext(), "vous devez remplir tous les chaùps!!", Toast.LENGTH_LONG).show();
                    } else {
                        String url = "http://"+globalvariable.ip+"/GoodTravelAppApi/cardcheck.php";
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                String res=response.trim();
                                if(res.equals("valide")){
                                    String payurl = "http://"+globalvariable.ip+"/GoodTravelAppApi/payement.php";
                                    StringRequest stringRequest1 = new StringRequest(Request.Method.POST, payurl, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            opendialogue();
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {

                                        }
                                    }) {
                                        @Override
                                        protected Map<String, String> getParams() {
                                            Map<String, String> params1 = new HashMap<String, String>();
                                            params1.put("user", globalvariable.user);
                                            params1.put("type", "Tour");
                                            params1.put("id", idt);
                                            params1.put("nbplace",nbrp);

                                            return params1;
                                        }
                                    };
                                    RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
                                    requestQueue1.add(stringRequest1);
                                }
                                Toast.makeText(getApplicationContext(), response.trim(), Toast.LENGTH_LONG).show();

                            }
                        },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }

                        ) {

                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("cardnumber", cnpp);
                                params.put("cardholder", chnpp);
                                params.put("crypto", crypp);
                                params.put("expyear", yearexp);
                                params.put("expmonth", monthexp);

                                return params;

                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(payment.this);
                        requestQueue.add(stringRequest);
                    }
                }
            });
        }







        }
        public void opendialogue(){
            afterreservationdialogue afterpaydia=new afterreservationdialogue();
            afterpaydia.show(getSupportFragmentManager(),"thanks");
        }

}

/*String payurl="http://192.168.56.1/GoodTravelAppApi/payementtravel.php";
                          StringRequest stringRequest1=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                              @Override
                              public void onResponse(String response) {
                                  Toast.makeText(getApplicationContext(), response.trim(), Toast.LENGTH_LONG).show();
                              }
                          }, new Response.ErrorListener() {
                              @Override
                              public void onErrorResponse(VolleyError error) {
                                  Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                              }
                          }){
                              @Override
                              protected Map<String, String> getParams(){
                              Map<String,String> params=new HashMap<String,String>();
                          params.put("user",globalvariable.user);
                          params.put("type","voyage");
                          params.put("id",idr);
                          params.put("nbplace",placesnumber);

                          return params;
                              }
                          };
                          RequestQueue requestQueue=Volley.newRequestQueue(payment.this);
                          requestQueue.add(stringRequest1);
*/