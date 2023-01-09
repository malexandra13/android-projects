package com.example.seminar05_1087;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void adaugaDate(View view) {
        EditText et = findViewById(R.id.editTextPersonName);
        String denumire = et.getText().toString();

        RatingBar rb = findViewById(R.id.ratingBar);
        int nrCredite = (int) rb.getRating();

        Switch st = findViewById(R.id.switch1);
        boolean examenOral = st.isChecked();

        EditText etNr = findViewById(R.id.editTextNumber);
        int nrOreCurs = Integer.parseInt(etNr.getText().toString());

        EditText etNr2 = findViewById(R.id.editTextNumber2);
        int nrOreSeminar = Integer.parseInt(etNr2.getText().toString());

        Curs curs = new Curs(denumire,nrCredite,examenOral,nrOreCurs,
        nrOreSeminar);

        Intent it = new Intent();
        it.putExtra("curs",curs);
        setResult(RESULT_OK, it);
        finish();
    }
}