package com.example.goodtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
ImageView back;
EditText usern,pass;
ImageView im;
Button logintohome;
String user,password,profilepic,us,ps;
RequestQueue rq;
String urljson="http://"+globalvariable.ip+"/GoodTravelAppApi/usersapi.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        back=findViewById(R.id.loginback);
        usern=findViewById(R.id.logusername);
        usern.setText(globalvariable.ip);
        pass=findViewById(R.id.logpass);
        logintohome=findViewById(R.id.Logintohome);
        user=usern.getText().toString();
        password=pass.getText().toString();
        rq= Volley.newRequestQueue(this);
        im=findViewById(R.id.background);
        animatebackgrounds.Animate(im,this);



        logintohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=usern.getText().toString();
                password=pass.getText().toString();
                if(user.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "All fields are necessary! ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Execut();
                }


            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainint=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainint);
                finish();
            }
        });
    }

    private class jsontask extends AsyncTask<String,Integer,String> {


        @Override
        protected String doInBackground(String... strings) {
            JsonObjectRequest reqhttp=new JsonObjectRequest(Request.Method.GET, strings[0], null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    boolean r=false;
                    try {
                        JSONArray users=response.getJSONArray("users");
                        for (int i=0;i<users.length();i++){
                            JSONObject user1=users.getJSONObject(i);
                            us=user1.getString("username");
                            ps=user1.getString("pass");
                            profilepic=user1.getString("pic");
                            if(us.equals(user) && ps.equals(password)){
                                r=true;
                                break;
                              }





                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(r==true){
                        globalvariable.user=us;
                        globalvariable.profilepic=profilepic;
                        globalvariable.pass=ps;
                        Intent intHome=new Intent(getApplicationContext(),Home1.class);
                        startActivity(intHome);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalide User Info", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
            rq.add(reqhttp);
            return "done";
        }
    }
    public void Execut(){
        jsontask task=new jsontask();
        task.execute(urljson);
    }
}