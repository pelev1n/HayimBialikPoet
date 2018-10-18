package com.andrewxa.hayimbialikpoet;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.poetry.PoetryListFragment;

public class PoetryCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mzmpzm);

        TextView mzmpzmTxtInside = (TextView) findViewById(R.id.poetry_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        mzmpzmTxtInside.setTypeface(myFont);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.poetry_fragment_container,
                        PoetryListFragment.newInstance("מזמורים ופזמונות"))
                .commit();
    }
}
