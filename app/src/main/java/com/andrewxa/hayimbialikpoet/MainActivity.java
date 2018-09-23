package com.andrewxa.hayimbialikpoet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.model.Poem;
import com.andrewxa.hayimbialikpoet.model.PoemText;
import com.andrewxa.hayimbialikpoet.model.Shira;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        RealmImporter.importFromJson(getResources());

        showShira();

        TextView name = (TextView) findViewById(R.id.name);
        TextView years = (TextView) findViewById(R.id.years);
        TextView biography = (TextView) findViewById(R.id.biography_text);
        TextView shira = (TextView) findViewById(R.id.shira_text);
        TextView proza = (TextView) findViewById(R.id.proza_text);
        TextView articles = (TextView) findViewById(R.id.articles_text);

        Typeface myFont = Typeface.createFromAsset(this.getAssets(), "fonts/shmulikclm.ttf");
        name.setTypeface(myFont);
        years.setTypeface(myFont);
        biography.setTypeface(myFont);
        shira.setTypeface(myFont);
        proza.setTypeface(myFont);
        articles.setTypeface(myFont);

        CardView shiraCard = (CardView) findViewById(R.id.shira_card);
        CardView prozaCard = (CardView) findViewById(R.id.proza_card);
        CardView articlesCard = (CardView) findViewById(R.id.articles_card);
        CardView biographyCard = (CardView) findViewById(R.id.biography_card);

        shiraCard.setOnClickListener(this);
        prozaCard.setOnClickListener(this);
        articlesCard.setOnClickListener(this);
        biographyCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shira_card:
                Intent shiraIntent = new Intent(MainActivity.this, ShiraActivity.class);
                startActivity(shiraIntent);
                break;
            case R.id.proza_card:
                Intent prozaIntent = new Intent(MainActivity.this, ProzaActivity.class);
                startActivity(prozaIntent);
                break;

            case R.id.articles_card:
                Intent articlesIntent = new Intent(MainActivity.this, ArticlesActivity.class);
                startActivity(articlesIntent);
                break;

            case R.id.biography_card:
                Intent biographyIntent = new Intent(MainActivity.this, BiographyActivity.class);
                startActivity(biographyIntent);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    public void showShira() {
        int poemTxt = realm.where(PoemText.class).findAll().size();
        if (poemTxt > 0) {
            System.out.println("!!!!!!!!!!!!!! POEM TEXT SIZE : " + poemTxt);
        } else  {
            System.out.println("!!!!!!!!!! NOTHING :( !!!!!!!!!!!!!!!" + poemTxt);
        }
    }
}
