package com.example.goodtravel;

import static java.lang.Thread.sleep;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class DBTask extends AsyncTask<String, Void, String> {

    Context ctx;

    public DBTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
       Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();

        try {
            sleep(1000);
            Intent intlog=new Intent(ctx,Login.class);
            ctx.startActivity(intlog);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://"+globalvariable.ip+"/GoodTravelAppApi/Regestration.php";
        String username=params[0];
        String email=params[1];
        String password=params[2];
        String birthdate=params[3];

        try {
            URL url=new URL(reg_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream os=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            String data= URLEncoder.encode("UserName","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                    URLEncoder.encode("Email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                    URLEncoder.encode("Pass","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                    URLEncoder.encode("datenaissance","UTF-8")+"="+URLEncoder.encode(birthdate,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            os.close();
            InputStream IS=httpURLConnection.getInputStream();
            IS.close();
            return "Registration Success !!";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
