package com.andrewxa.hayimbialikpoet.shirim;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.R;
import com.andrewxa.hayimbialikpoet.poetry.PoetryListFragment;

public class ShirimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirim);

        TextView shirimTxtInside =  findViewById(R.id.poetry_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(), "fonts/shmulikclm.ttf");
        shirimTxtInside.setTypeface(myFont);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.poetry_fragment_container,
                        PoetryListFragment.newInstance("שירים"))
                .commit();
    }

}
