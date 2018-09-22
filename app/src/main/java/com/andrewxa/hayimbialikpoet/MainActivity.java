package com.andrewxa.hayimbialikpoet;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = (TextView) findViewById(R.id.name);
        TextView years = (TextView) findViewById(R.id.years);
        TextView biography = (TextView) findViewById(R.id.biography_text);
        TextView shira = (TextView) findViewById(R.id.shira_text);
        TextView proza = (TextView) findViewById(R.id.proza_text);
        TextView articles = (TextView) findViewById(R.id.articles_text);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        name.setTypeface(myFont);
        years.setTypeface(myFont);
        biography.setTypeface(myFont);
        shira.setTypeface(myFont);
        proza.setTypeface(myFont);
        articles.setTypeface(myFont);
    }
}
