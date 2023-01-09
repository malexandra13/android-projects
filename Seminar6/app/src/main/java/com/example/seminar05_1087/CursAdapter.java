package com.example.seminar05_1087;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class CursAdapter extends BaseAdapter {

    private Context context;
    private int resource;
    private List<Curs> listaCursuri;

    public CursAdapter(Context context, int resource, List<Curs> listaCursuri){
        this.context=context;
        this.resource=resource;
        this.listaCursuri=listaCursuri;
    }

    @Override
    public int getCount() {

        return listaCursuri.size();
    }

    @Override
    public Object getItem(int i) {
        if(i>=0 && i<listaCursuri.size()){
            return listaCursuri.get(i);
        }
        else return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Curs c = listaCursuri.get(i);
        LayoutInflater li = LayoutInflater.from(context);
        View v = li.inflate(resource, viewGroup, false);

        TextView tv_den = v.findViewById(R.id.textView_denumire);
        tv_den.setText(c.getDenumire());

        TextView tv_credite = v.findViewById(R.id.textView_nrCredite);
        tv_credite.setText(String.valueOf(c.getNrCredite()));

        TextView tv_oreS = v.findViewById(R.id.textView_oreSeminar);
        tv_oreS.setText(String.valueOf(c.getNrOreSeminar()));

        TextView tv_oreC = v.findViewById(R.id.textView_oreCurs);
        tv_oreC.setText(String.valueOf(c.getNrOreCurs()));

        RadioButton rb_examen = v.findViewById(R.id.radioButton_examen);
        rb_examen.setChecked(c.isExamenOral());

        return v;
    }
}
