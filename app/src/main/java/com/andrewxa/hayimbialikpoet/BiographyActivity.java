package com.andrewxa.hayimbialikpoet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BiographyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography);

        TextView biographyInside = (TextView) findViewById(R.id.biography_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        biographyInside.setTypeface(myFont);
    }
}
