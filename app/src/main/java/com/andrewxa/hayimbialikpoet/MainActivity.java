package com.andrewxa.hayimbialikpoet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.model.Poem;
import com.andrewxa.hayimbialikpoet.poetrytypes.PoetryTypesActivity;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        dropDB();
        initDB();
        showPoems();

        TextView name = (TextView) findViewById(R.id.name);
        TextView years = (TextView) findViewById(R.id.years);
        TextView biography = (TextView) findViewById(R.id.shirot_text);
        TextView shira = (TextView) findViewById(R.id.shirim_text);
        TextView proza = (TextView) findViewById(R.id.yatmot_text);
        TextView articles = (TextView) findViewById(R.id.mzmpzm_text);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(), "fonts/shmulikclm.ttf");
        name.setTypeface(myFont);
        years.setTypeface(myFont);
        biography.setTypeface(myFont);
        shira.setTypeface(myFont);
        proza.setTypeface(myFont);
        articles.setTypeface(myFont);

        CardView shiraCard = (CardView) findViewById(R.id.shirim_card);
        CardView prozaCard = (CardView) findViewById(R.id.yatmot_card);
        CardView articlesCard = (CardView) findViewById(R.id.mzmpzm_card);
        CardView biographyCard = (CardView) findViewById(R.id.shirot_card);

        shiraCard.setOnClickListener(this);
        prozaCard.setOnClickListener(this);
        articlesCard.setOnClickListener(this);
        biographyCard.setOnClickListener(this);

    }

    private void initDB() {
        RealmImporter.importFromJson(getResources(), getJsonPath("shirashirim"));
        RealmImporter.importFromJson(getResources(), getJsonPath("shirashirot"));
        RealmImporter.importFromJson(getResources(), getJsonPath("shiramzmpzm"));
        RealmImporter.importFromJson(getResources(), getJsonPath("shirayatmot"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shirim_card:
                Intent shiraIntent = new Intent(MainActivity.this, PoetryTypesActivity.class);
                shiraIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(shiraIntent, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.yatmot_card:
                Intent prozaIntent = new Intent(MainActivity.this, ProzaActivity.class);
                prozaIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(prozaIntent, 0);
                overridePendingTransition(0,0);
                break;

            case R.id.mzmpzm_card:
                Intent articlesIntent = new Intent(MainActivity.this, ArticlesActivity.class);
                articlesIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(articlesIntent, 0);
                overridePendingTransition(0,0);
                break;

            case R.id.shirot_card:
                Intent biographyIntent = new Intent(MainActivity.this, BiographyActivity.class);
                startActivityForResult(biographyIntent, 0);
                overridePendingTransition(0,0);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    public void dropDB() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    public int getJsonPath(String jsonName) {
        int rawResourceId = this.getResources().getIdentifier(jsonName, "raw", this.getPackageName());
        return rawResourceId;
    }

    public void showPoems() {
        int poemTxt = realm.where(Poem.class).findAll().size();
        if (poemTxt > 0) {
            System.out.println("!!!!!!!!!!!!!! POEM TEXT SIZE : " + poemTxt);
        } else {
            System.out.println("!!!!!!!!!! NOTHING :( !!!!!!!!!!!!!!!" + poemTxt);
        }
    }
}
