package com.andrewxa.hayimbialikpoet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProzaActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proza);

        TextView prozaInside = (TextView) findViewById(R.id.proza_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        prozaInside.setTypeface(myFont);
    }
}
