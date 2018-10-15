package com.andrewxa.hayimbialikpoet;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.andrewxa.hayimbialikpoet.model.poetrycard.PoetryCard;
import com.andrewxa.hayimbialikpoet.shirim.ShirimActivity;
import com.andrewxa.hayimbialikpoet.util.RealmImporter;
import com.andrewxa.hayimbialikpoet.util.Util;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity{

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

        /*RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        PoetryCardAdapter myAdapter = new PoetryCardAdapter(lstPoetryCard);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);*/

        Util.setFont(this,findViewById(R.id.name));
        Util.setFont(this,findViewById(R.id.years));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        PoetryCardAdapter myAdapter = new PoetryCardAdapter(lstPoetryCard);
/*        myrv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        myrv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));*/
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);

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

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
