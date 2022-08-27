package com.example.goodtravel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TravelByFlight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TravelByFlight extends Fragment {
    RecyclerView rv;
    ArrayList<Travel> lt;
    TravelsAdapter ta;
    EditText travelfilter;
    ImageView search;
    String filter;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TravelByFlight() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TravelByFlight.
     */
    // TODO: Rename and change types and number of parameters
    public static TravelByFlight newInstance(String param1, String param2) {
        TravelByFlight fragment = new TravelByFlight();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout= inflater.inflate(R.layout.fragment_travel_by_flight, container, false);
        rv=layout.findViewById(R.id.filghtrecycler);
        lt=new ArrayList<Travel>();
        travelfilter=layout.findViewById(R.id.trf);
        search=layout.findViewById(R.id.sarch);

        travelfilter.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                lt=new ArrayList<Travel>();
                filter=travelfilter.getText().toString();
                String url;
                if(filter.equals("")){
                    url = "http://"+globalvariable.ip+"/GoodTravelAppApi/travelsapi.php?outile=flight&vd=all";
                }
                else{
                    url = "http://"+globalvariable.ip+"/GoodTravelAppApi/travelsapi.php?outile=flight&vd="+filter;
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
                                JSONArray Travels = jsonObject.getJSONArray("Travels");
                                for (int i = 0; i < Travels.length(); i++) {
                                    JSONObject travel = Travels.getJSONObject(i);
                                    String id=travel.getString("id");
                                    String vd = travel.getString("vd");
                                    String va = travel.getString("va");
                                    String dd = travel.getString("dd");
                                    String da = travel.getString("da");
                                    String prix = travel.getString("prix");
                                    String hd = travel.getString("hd");
                                    String ha = travel.getString("ha");
                                    String capacite = travel.getString("capacite");
                                    String outile=travel.getString("outile");


                                    Travel s = new Travel(id,vd, va, dd, da, prix,hd,ha,capacite,outile);
                                    lt.add(s);
                                }

                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ta = new TravelsAdapter(lt);
                                        rv.setLayoutManager(new LinearLayoutManager(getContext()));
                                        rv.setAdapter(ta);

                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                return false;
            }
        });

       search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });


        final String[] myresponse = new String[1];
        OkHttpClient client = new OkHttpClient();
        String url = "http://"+globalvariable.ip+"/GoodTravelAppApi/travelsapi.php?outile=flight&vd=all";
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
                        JSONArray Travels = jsonObject.getJSONArray("Travels");
                        for (int i = 0; i < Travels.length(); i++) {
                            JSONObject travel = Travels.getJSONObject(i);
                            String id=travel.getString("id");
                            String vd = travel.getString("vd");
                            String va = travel.getString("va");
                            String dd = travel.getString("dd");
                            String da = travel.getString("da");
                            String prix = travel.getString("prix");
                            String hd = travel.getString("hd");
                            String ha = travel.getString("ha");
                            String capacite = travel.getString("capacite");
                            String outile=travel.getString("outile");


                            Travel s = new Travel(id,vd, va, dd, da, prix,hd,ha,capacite,outile);
                            lt.add(s);
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ta = new TravelsAdapter(lt);
                                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                                rv.setAdapter(ta);

                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });





        return layout;
    }

}