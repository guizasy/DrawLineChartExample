package com.gzmachado.drawlinechartexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.Collections;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by gzmachado on 06/10/16.
 */

public class ViewChart extends View {
    private static final int MIN_LINES = 4;
    private static final int MAX_LINES = 7;
    private static final int[] DISTANCES = { 1, 2, 5 };
    private float[] datapoints = new float[] {};
    private Paint paint = new Paint();

    public ViewChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private float getMax(float[] datapoints) {
        float max = datapoints[0];

        for (int i = 0; i < datapoints.length; i++) {
            if (datapoints[i] > max) {
                max = datapoints[i];
            }
        }

        return max;
    }

    private float getXPos(float value, float maxValue) {
        float width = getWidth() - getPaddingRight() - getPaddingLeft();

        value = (value / maxValue) * width;
        value = width - value;
        value += getPaddingRight();

        return value;
    }

    private float getYPos(float value, float maxValue) {
        float height = getHeight() - getPaddingTop() - getPaddingBottom();

        value = (value / maxValue) * height;
        value = height - value;
        value += getPaddingTop();

        return value;
    }

    public void setChartData(float[] datapoints) {
        this.datapoints = datapoints.clone();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawLineChart(canvas);
    }

    private void drawLineChart(Canvas canvas) {
        float maxValue = getMax(datapoints);
        Path path = new Path();

        path.moveTo(getXPos(0, datapoints.length), getYPos(datapoints[0], maxValue));

        for (int i = 1; i < datapoints.length; i++) {
            path.lineTo(getXPos(i, datapoints.length), getYPos(datapoints[i], maxValue));
        }

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(0xff33bbee);
        paint.setAntiAlias(true);
        paint.setShadowLayer(4, 2, 2, 0x7f000000);
        canvas.drawPath(path, paint);
        paint.setShadowLayer(0, 0, 0, 0);
    }
}