package com.andrewxa.hayimbialikpoet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andrewxa.hayimbialikpoet.model.poetrycard.PoetryCard;
import com.andrewxa.hayimbialikpoet.util.RealmImporter;
import com.andrewxa.hayimbialikpoet.util.Util;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    List<PoetryCard> lstPoetryCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        dropDB();
        initDB();

        lstPoetryCard = new ArrayList<>();
        lstPoetryCard.add(new PoetryCard("יתמות",R.drawable.ic_yatmot));
        lstPoetryCard.add(new PoetryCard("שירים",R.drawable.ic_shira));
        lstPoetryCard.add(new PoetryCard("שירות",R.drawable.ic_shirot));
        lstPoetryCard.add(new PoetryCard("מזמורים ופזמונות",R.drawable.ic_mzmpzm));
        lstPoetryCard.add(new PoetryCard("שירים לילדים",R.drawable.ic_boyandgirl));
        lstPoetryCard.add(new PoetryCard("שירים מן העזבון",R.drawable.ic_shirimazvon));

        Util.setFont(this,findViewById(R.id.name));
        Util.setFont(this,findViewById(R.id.years));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        PoetryCardAdapter poetryCardAdapter = new PoetryCardAdapter(lstPoetryCard);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(poetryCardAdapter);

        poetryCardAdapter.setpoetryCardClickListener(position -> {
            PoetryCard poetryCard = lstPoetryCard.get(position);
            Intent intent = new Intent(this,PoetryCardActivity.class);
            intent.putExtra("poetrycard",poetryCard);
            startActivity(intent);
        });
    }

    public void initDB() {
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this, "shirashirim"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this, "shirashirot"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this, "shiramzmpzm"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this, "shirayatmot"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this, "shireladim"));
        RealmImporter.importFromJson(getResources(), Util.getJsonPath(this, "shirizavon"));
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
