package com.example.seminar2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void apasareButton(View view) {
        Button btn = findViewById(R.id.button);
        btn.setText("Ai apasat");
    }

    public void apasareButonDinNou(View view) {
        Button btn2 = findViewById(R.id.button2);
        btn2.setText("Ai apasat din nou butonul!");

        TextView tv = findViewById(R.id.textView);
        tv.setText("Cine a apasat din nou!");
    }
}