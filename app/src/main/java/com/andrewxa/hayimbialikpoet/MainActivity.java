package com.andrewxa.hayimbialikpoet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.model.Poem;
import com.andrewxa.hayimbialikpoet.shirim.ShirimActivity;
import com.andrewxa.hayimbialikpoet.util.RealmImporter;

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

        initFont();

        CardView shirimCard = (CardView) findViewById(R.id.shirim_card);
        CardView yatmotCard = (CardView) findViewById(R.id.yatmot_card);
        CardView mzmpzmCard = (CardView) findViewById(R.id.mzmpzm_card);
        CardView shirotCard = (CardView) findViewById(R.id.shirot_card);
        CardView shirimazvonCard = (CardView) findViewById(R.id.shirimazvon_card);
        CardView eladimCard = (CardView) findViewById(R.id.eladim_card);

        shirimCard.setOnClickListener(this);
        yatmotCard.setOnClickListener(this);
        mzmpzmCard.setOnClickListener(this);
        shirotCard.setOnClickListener(this);
        shirimazvonCard.setOnClickListener(this);
        eladimCard.setOnClickListener(this);

    }

    private void initDB() {
        RealmImporter.importFromJson(getResources(), getJsonPath("shirashirim"));
        RealmImporter.importFromJson(getResources(), getJsonPath("shirashirot"));
        RealmImporter.importFromJson(getResources(), getJsonPath("shiramzmpzm"));
        RealmImporter.importFromJson(getResources(), getJsonPath("shirayatmot"));
        RealmImporter.importFromJson(getResources(), getJsonPath("shireladim"));
        RealmImporter.importFromJson(getResources(), getJsonPath("shirizavon"));
    }

    private void initFont() {
        TextView name = (TextView) findViewById(R.id.name);
        TextView years = (TextView) findViewById(R.id.years);
        TextView shirim = (TextView) findViewById(R.id.shirim_text);
        TextView yatmot = (TextView) findViewById(R.id.yatmot_text);
        TextView mzmpzm = (TextView) findViewById(R.id.mzmpzm_text);
        TextView shirot = (TextView) findViewById(R.id.shirot_text);
        TextView shirimazvon = (TextView) findViewById(R.id.shirimazvon_text);
        TextView eladim = (TextView) findViewById(R.id.eladim_text);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(), "fonts/shmulikclm.ttf");
        name.setTypeface(myFont);
        years.setTypeface(myFont);
        shirim.setTypeface(myFont);
        yatmot.setTypeface(myFont);
        mzmpzm.setTypeface(myFont);
        shirot.setTypeface(myFont);
        shirimazvon.setTypeface(myFont);
        eladim.setTypeface(myFont);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shirim_card:
                Intent shirimIntent = new Intent(MainActivity.this, ShirimActivity.class);
                shirimIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(shirimIntent, 0);
                overridePendingTransition(0,0);
                break;
            case R.id.yatmot_card:
                Intent yatmotIntent = new Intent(MainActivity.this, YatmotActivity.class);
                yatmotIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(yatmotIntent, 0);
                overridePendingTransition(0,0);
                break;

            case R.id.mzmpzm_card:
                Intent mzmpzmIntent = new Intent(MainActivity.this, MzmpzmActivity.class);
                mzmpzmIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(mzmpzmIntent, 0);
                overridePendingTransition(0,0);
                break;

            case R.id.shirot_card:
                Intent shirotIntent = new Intent(MainActivity.this, ShirotActivity.class);
                shirotIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(shirotIntent, 0);
                overridePendingTransition(0,0);
                break;

            case R.id.shirimazvon_card:
                Intent shirimAzvon = new Intent(MainActivity.this, ShirimIzavonActivity.class);
                shirimAzvon.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(shirimAzvon, 0);
                overridePendingTransition(0,0);
                break;

            case R.id.eladim_card:
                Intent eladimIntent = new Intent(MainActivity.this, EladimActivity.class);
                startActivityForResult(eladimIntent, 0);
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
