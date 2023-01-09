package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("text","sir de caractere");
                bundle.putInt("valoare",345);
                Caine caine=new Caine();
                bundle.putParcelable("caine",caine);
                it.putExtras(bundle);
                //startActivity(it);//deschidem o activitate in mod INDEPENDENT
                startActivityForResult(it,123);//
            }
        });

    }

    //call back
    //deschidem o activitate in mod DEPENDENT
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode==123){
//            if(resultCode == RESULT_OK){
//                int resultIntreg=data.getIntExtra("valIntreaga",0);
//                float resultFloat=data.getFloatExtra("valReala",0);
//                double resultDouble=data.getDoubleExtra("valDouble",0);
//
//                Toast.makeText(this," "+resultIntreg+" "+resultFloat+" "+resultDouble,Toast.LENGTH_LONG).show();
//
//            }
//        }
//    }
}

/*
 *   Toate activitatile se deschid prin intermediul unui intent. Deci orice activitate lansata are un intent
 *
 * */