package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PieChartGrafic extends View {
    private List<Integer> valori;

    public PieChartGrafic(Context context, List<Integer> valori) {
        super(context);
        this.valori = valori;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<Float> proportii = new ArrayList<>();
        int r = 0, g = 0, b = 0;
        float startAngle = 0;
        Float suma = 0f;
        Paint paint = new Paint();


        for (Integer valoare : valori) {
            suma += valoare;
        }
        for (Integer valoare : valori) {
            proportii.add(valoare / suma * 360f);
        }

        for (int i = 0; i < valori.size(); i++) {
            paint.setColor(Color.rgb(r%256, g%256, b%256));
            r += 30;
            g += 60;
            b += 90;

            canvas.drawArc(50, 50, 500, 500, startAngle, proportii.get(i), true, paint);
            startAngle += proportii.get(i);

        }

    }
}
