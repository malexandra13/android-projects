package com.example.seminar05_1087;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaCursuri = new ArrayList<>();

        ListView lv = findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, listaCursuri.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                listaCursuri.remove(position);
                seteazaAdapterLista();
                return false;
            }
        });

        Button bt = findViewById(R.id.buttonActivitateNoua);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MainActivity2.class);
                startActivityForResult(it,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                Curs c = data.getParcelableExtra("curs");
                Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show();
                listaCursuri.add(c);
                seteazaAdapterLista();
            }
        }
    }

    private void seteazaAdapterLista(){
        //ArrayAdapter<Curs> adapter;
        //adapter = new ArrayAdapter<Curs>(getApplicationContext(), android.R.layout.simple_list_item_1,listaCursuri);
        CursAdapter cursAdapter = new CursAdapter(getApplicationContext(),R.layout.layout_curs_new,
                listaCursuri);
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(cursAdapter);
        //lv.setAdapter(adapter);
    }

    List<Curs> listaCursuri;


}