package com.example.lab1_canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class MyCanvasView extends View {
    Paint paint;

    public MyCanvasView(Context context) {
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Arka planı sarı yap
        canvas.drawColor(Color.YELLOW);

        // Kahverengi renk ayarı
        paint.setColor(Color.rgb(165, 42, 42));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        int width = getWidth();
        int height = getHeight();
        int cx = width / 2;
        int cy = height / 2;
        int rays = 14;
        int radius = Math.min(cx, cy) - 50;

        // 14 ışın çiz
        for (int i = 0; i < rays; i++) {
            double angle = 2 * Math.PI * i / rays;
            int x = cx + (int)(radius * Math.cos(angle));
            int y = cy + (int)(radius * Math.sin(angle));
            canvas.drawLine(cx, cy, x, y, paint);
        }

        // Üçgen çiz
        paint.setStyle(Paint.Style.FILL);
        Path triangle = new Path();
        triangle.moveTo(cx, cy - 100);
        triangle.lineTo(cx - 100, cy + 100);
        triangle.lineTo(cx + 100, cy + 100);
        triangle.close();
        canvas.drawPath(triangle, paint);
    }
}
