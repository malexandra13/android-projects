package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it= getIntent();
        String text=it.getStringExtra("text");
        it.getStringExtra("text");
        int valoare=it.getIntExtra("valoare",0);

        Toast.makeText(this,text+" "+valoare,Toast.LENGTH_SHORT).show();

        Button btn_ok=findViewById(R.id.button_ok);
        Button btn_cancel=findViewById(R.id.button_cancel);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
                it.putExtra("valIntreaga",678);
                it.putExtra("valReala",9.67f);
                it.putExtra("valDouble",6.87);
                setResult(RESULT_OK,it);
                finish();
            }
        });
    }
}