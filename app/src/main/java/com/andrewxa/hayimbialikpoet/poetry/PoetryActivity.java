package com.andrewxa.hayimbialikpoet.poetry;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.R;
import com.andrewxa.hayimbialikpoet.poetry.menu.PoetryMenuFragment;

public class PoetryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poetry);

        TextView shiraInside =  findViewById(R.id.shira_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(), "fonts/shmulikclm.ttf");
        shiraInside.setTypeface(myFont);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.poetry_fragment_container, PoetryMenuFragment.newInstance())
                .commit();
    }

}
