package com.shoon.android_performance_customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DialView gv=findViewById(R.id.dial_volume);
        //SliderView sl=findViewById(R.id.slider_rate);
   }
}
