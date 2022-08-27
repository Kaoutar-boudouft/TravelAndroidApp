package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class Tours extends AppCompatActivity {
Spinner spin;
RecyclerView tourrecycler;
    ArrayList<Tour> lt;
    ToursAdapter ta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);
        tourrecycler=findViewById(R.id.tourrecyc);
        spin=findViewById(R.id.spinner);
        lt=new ArrayList<Tour>();

        String [] tabcategories={"Student Package","Family Package","OnePersone Package","all"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,tabcategories);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int p=spin.getSelectedItemPosition();
                String si=spin.getItemAtPosition(p).toString();
                String url;
                lt=new ArrayList<Tour>();
                if(si.equals("all")){
                  url = "http://"+globalvariable.ip+"/GoodTravelAppApi/toursapi.php?cate=all";
                }
                else {
                    url = "http://"+globalvariable.ip+"/GoodTravelAppApi/toursapi.php?cate="+(p+1);
                }
                final String[] myresponse = new String[1];
                OkHttpClient client = new OkHttpClient();
                okhttp3.Request request = new okhttp3.Request.Builder().url(url).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            myresponse[0] = response.body().string();
                            try {
                                JSONObject jsonObject = new JSONObject(myresponse[0]);
                                JSONArray Tours = jsonObject.getJSONArray("Tours");
                                for (int i = 0; i < Tours.length(); i++) {
                                    JSONObject travel = Tours.getJSONObject(i);
                                    String idt=travel.getString("idtour");
                                    String vd = travel.getString("titre");
                                    String va = travel.getString("date");
                                    String dd = travel.getString("prix");
                                    String da = travel.getString("image");
                                    String cap = travel.getString("capacite");
                                    String cate = travel.getString("categ");




                                    Tour s = new Tour(idt,vd, va, dd, da,cap,cate);
                                    lt.add(s);
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ta = new ToursAdapter(lt);
                                        tourrecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                        tourrecycler.setAdapter(ta);

                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String[] myresponse = new String[1];
        OkHttpClient client = new OkHttpClient();
        String url = "http://"+globalvariable.ip+"/GoodTravelAppApi/toursapi.php?cate=1";
        okhttp3.Request request = new okhttp3.Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    myresponse[0] = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(myresponse[0]);
                        JSONArray Tours = jsonObject.getJSONArray("Tours");
                        for (int i = 0; i < Tours.length(); i++) {
                            JSONObject travel = Tours.getJSONObject(i);
                            String idt=travel.getString("idtour");
                            String vd = travel.getString("titre");
                            String va = travel.getString("date");
                            String dd = travel.getString("prix");
                            String da = travel.getString("image");
                            String cap = travel.getString("capacite");
                            String cate = travel.getString("categ");




                            Tour s = new Tour(idt,vd, va, dd, da,cap,cate);
                            lt.add(s);
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ta = new ToursAdapter(lt);
                                tourrecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                tourrecycler.setAdapter(ta);

                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}