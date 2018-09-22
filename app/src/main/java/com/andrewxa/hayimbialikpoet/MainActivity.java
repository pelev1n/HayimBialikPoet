package com.andrewxa.hayimbialikpoet;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name;
    TextView years;
    Typeface myFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.name);
        years = (TextView) findViewById(R.id.years);

        myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        name.setTypeface(myFont);
        years.setTypeface(myFont);
    }
}
