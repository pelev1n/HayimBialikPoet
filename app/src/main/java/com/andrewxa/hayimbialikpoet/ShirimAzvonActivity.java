package com.andrewxa.hayimbialikpoet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShirimAzvonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirim_azvon);

        TextView shirimAzvonInside = (TextView) findViewById(R.id.shirimAzvon_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        shirimAzvonInside.setTypeface(myFont);
    }
}
