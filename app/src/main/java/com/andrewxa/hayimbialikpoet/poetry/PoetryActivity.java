package com.andrewxa.hayimbialikpoet.poetry;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.R;
import com.andrewxa.hayimbialikpoet.model.Poetry;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class PoetryActivity extends AppCompatActivity {

    Realm realm;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poetry);
        realm = Realm.getDefaultInstance();

        TextView shiraInside = (TextView) findViewById(R.id.shira_text_inside);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(), "fonts/shmulikclm.ttf");
        shiraInside.setTypeface(myFont);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.poetry_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PoetryAdapter poetryAdapter = new PoetryAdapter(getAllPoetryTypes());
        recyclerView.setAdapter(poetryAdapter);
    }

    public List<String> getAllPoetryTypes() {
        List <String> poetryType = new ArrayList<>(3);
        poetryType.add("שירים");
        poetryType.add("יתמות");
        poetryType.add("מזמורים ופזמונות");
        poetryType.add("שירות");

        return poetryType;
    }
}
