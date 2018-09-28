package com.andrewxa.hayimbialikpoet.shira;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.R;

public class PoetryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shira);

        TextView shiraInside = (TextView) findViewById(R.id.shira_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        shiraInside.setTypeface(myFont);
    }
}
