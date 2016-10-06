package com.gzmachado.drawlinechartexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewChart viewLineChart = (ViewChart) findViewById(R.id.viewchart);
        viewLineChart.setChartData(getSampleData());
    }

    private float[] getSampleData() {
        return new float[] {10, 12, 7, 14, 15, 19, 13, 2, 10, 13, 13, 10, 15, 14};
    }
}
