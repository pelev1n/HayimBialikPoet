package com.andrewxa.hayimbialikpoet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShirotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirot);

        TextView shirotTxtInside = (TextView) findViewById(R.id.shirot_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        shirotTxtInside.setTypeface(myFont);
    }
}
