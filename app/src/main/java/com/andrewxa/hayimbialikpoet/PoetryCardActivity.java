package com.andrewxa.hayimbialikpoet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.model.poetrycard.PoetryCard;
import com.andrewxa.hayimbialikpoet.poetry.PoetryListFragment;
import com.andrewxa.hayimbialikpoet.util.Util;

public class PoetryCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poetry_card_activity);
        PoetryCard poetryCard = (PoetryCard) getIntent().getSerializableExtra("poetrycard");
        ((ImageView)findViewById(R.id.poetry_fragment_img)).setImageResource(poetryCard.getThumbnail());

        TextView poetryText =  findViewById(R.id.poetry_fragment_txt);
        Util.setFont(this,poetryText);
        poetryText.setText(poetryCard.getTitle());

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.poetry_fragment_container,
                        PoetryListFragment.newInstance(poetryCard.getTitle()))
                .commit();
    }
}
