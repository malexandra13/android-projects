package com.example.seminar3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"A fost creata activitatea in memorie",Toast.LENGTH_SHORT).show();

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Lifecycle","A fost apelata metoda onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle","A fost apelata metoda onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","A fost apelata metoda onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Lifecycle","A fost apelata metoda onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Lifecycle","A fost apelata metoda onDestroy");
    }
}