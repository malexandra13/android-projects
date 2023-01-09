package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Desen extends View {

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint(); //ne cream un obiect de tip Paint
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawCircle(200,200,180,paint);

        Paint paint1=new Paint();
        paint1.setColor(Color.rgb(100,78,145));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(400,20,610,380,paint1);

        Paint paint2=new Paint();
        paint2.setColor(Color.GREEN);
        paint2.setTextSize(50);
        canvas.drawText("DISPOZITIVE",40,460,paint2);

        canvas.drawArc(40,500,340,820,200,60,true,paint);

    }

    public Desen(Context context) {
        super(context);
    }
}
