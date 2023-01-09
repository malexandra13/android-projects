package com.example.seminar9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExecutorService executorService=Executors.newSingleThreadExecutor();
                Handler handler=new Handler(Looper.myLooper());
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            URL url=new URL("https://pastebin.com/raw/dFgjRd8E");
                            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                            InputStream is=connection.getInputStream();

                            BufferedReader br=new BufferedReader(new InputStreamReader(is));
                            StringBuilder sb=new StringBuilder();

                            String line;

                            while((line=br.readLine())!=null){
                                sb.append(line);
                            }


                            JSONObject jsonObject=new JSONObject(sb.toString());
                            JSONArray jsonArray=jsonObject.getJSONArray("DailyForecasts");
                            JSONObject obj=jsonArray.getJSONObject(0);

                            JSONObject temperatura=obj.getJSONObject("Temperature");
                            JSONObject minim=temperatura.getJSONObject("Minimum");
                            JSONObject maxim=temperatura.getJSONObject("Maximum");

                            String valMin=minim.getString("Value");
                            String valMax=maxim.getString("Value");
                            String simbol=minim.getString("Unit");

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    StringBuilder sbText=new StringBuilder();
                                    sbText.append("Temperatura minima: ").append(valMin).append(simbol).
                                            append("- maxima: ").append(valMax).append(simbol);
                                    TextView tv=findViewById(R.id.textView);
                                    tv.setText(sbText);
                                }
                            });
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }
}

//! api key: BmijxbuaBT3QDkqSbB4sAR5hQbtZ87uf
//! key Bucharest 287430
//JSON Array incepe cu [ ]
//JSON Object incepe cu { }