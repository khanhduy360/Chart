package com.example.hw1_duy_b1605326;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button lineplot, barchart, piechart, btnexit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineplot = findViewById(R.id.lineplot);
        barchart = findViewById(R.id.barplot);
        piechart = findViewById(R.id.pieplot);
        btnexit = findViewById(R.id.thoat);
        lineplot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t1 = new Intent(MainActivity.this, NhaplieuLinesPlot.class);
                startActivity(t1);
            }
        });
        barchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this, BarChartsActivity.class);
                startActivity(i2);
            }
        });
        piechart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this, PieChartsActivity.class);
                startActivity(i3);
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


    }
}



