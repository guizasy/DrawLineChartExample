package com.gzmachado.drawlinechartexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gzmachado on 06/10/16.
 */

public class ViewLine extends View {
    public ViewLine(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFFFF0000);
        paint.setStrokeWidth(8);

        setBackgroundColor(getResources().getColor(R.color.colorBackground, null));

        int left = getPaddingLeft();
        int top = getPaddingTop();
        int right = getWidth() - getPaddingRight();
        int botton = getHeight() - getPaddingBottom();
        canvas.drawLine(left, top, right, botton, paint);
    }
}
