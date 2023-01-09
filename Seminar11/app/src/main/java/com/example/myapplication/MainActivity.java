package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main); //seteaza ce View sa-mi afiseze

        Desen desen = new Desen(this);
//        setContentView(desen);

        List<Integer> valori = new ArrayList<>();
        valori.add(10);
        valori.add(10);
        valori.add(30);
        valori.add(300);
        valori.add(200);
        PieChartGrafic pieChartGrafic = new PieChartGrafic(this, valori);
        setContentView(pieChartGrafic);


    }
}