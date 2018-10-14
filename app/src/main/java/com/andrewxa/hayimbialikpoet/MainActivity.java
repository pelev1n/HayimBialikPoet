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
import com.andrewxa.hayimbialikpoet.util.Util;

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

        initFont();

        findViewById(R.id.shirim_card).setOnClickListener(this);
        findViewById(R.id.yatmot_card).setOnClickListener(this);
        findViewById(R.id.mzmpzm_card).setOnClickListener(this);
        findViewById(R.id.shirot_card).setOnClickListener(this);
        findViewById(R.id.shirimazvon_card).setOnClickListener(this);
        findViewById(R.id.eladim_card).setOnClickListener(this);

    }

    private void initDB() {
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this,"shirashirim"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this,"shirashirot"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this,"shiramzmpzm"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this,"shirayatmot"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this,"shireladim"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this,"shirizavon"));
    }

    private void initFont() {

        Util.setFont(this,findViewById(R.id.name));
        Util.setFont(this,findViewById(R.id.years));
        Util.setFont(this,findViewById(R.id.shirim_text));
        Util.setFont(this,findViewById(R.id.yatmot_text));
        Util.setFont(this,findViewById(R.id.mzmpzm_text));
        Util.setFont(this,findViewById(R.id.shirot_text));
        Util.setFont(this,findViewById(R.id.shirimazvon_text));
        Util.setFont(this,findViewById(R.id.eladim_text));
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

}
