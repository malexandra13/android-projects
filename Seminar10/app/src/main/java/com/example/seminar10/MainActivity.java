package com.example.seminar10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MasinaDatabase masinaDatabase=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        masinaDatabase= Room.databaseBuilder(getApplicationContext(),
                MasinaDatabase.class,"DatabaseMasini").
                allowMainThreadQueries().build();
    }

    public void adaugaMasini(View view){
        Masina m1=new Masina("Audi",20f,"negru",5);
        Masina m2=new Masina("Bmw",30f,"alb",2);
        Masina m3=new Masina("Toyota",27.5f,"rosu",7);

        masinaDatabase.getMasinaDao().insereazaMasina(m1);
        masinaDatabase.getMasinaDao().insereazaMasina(m2);
        masinaDatabase.getMasinaDao().insereazaMasina(m3);

    }

    public void afiseazaMasini(View view){
        List<Masina> listaMasini=masinaDatabase.getMasinaDao().selectMasini();
        Toast.makeText(this,listaMasini.toString(),Toast.LENGTH_LONG).show();
    }

    public void updateMasini(View view){
        String model="Audi";
        int nrLoc=8;

        masinaDatabase.getMasinaDao().updateMasina2(nrLoc,model);
        List<Masina> listaMasini=masinaDatabase.getMasinaDao().selectMasini();
        Toast.makeText(this,listaMasini.toString(),Toast.LENGTH_LONG).show();
    }


}