package com.andrewxa.hayimbialikpoet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.poetry.PoetryListFragment;

public class ShirimIzavonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirim_azvon);

        TextView shirimAzvonInside = (TextView) findViewById(R.id.poetry_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(),"fonts/shmulikclm.ttf");
        shirimAzvonInside.setTypeface(myFont);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.poetry_fragment_container,
                        PoetryListFragment.newInstance("שירים מן העזבון"))
                .commit();
    }
}
