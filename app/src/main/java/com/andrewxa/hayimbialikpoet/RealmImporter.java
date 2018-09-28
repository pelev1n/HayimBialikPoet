package com.andrewxa.hayimbialikpoet;

import android.content.res.Resources;
import android.util.Log;

import java.io.InputStream;

import io.realm.Realm;


public class RealmImporter {

    static void importFromJson(final Resources resources) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                InputStream inputStream = resources.openRawResource(R.raw.shirajson);
                try {
                    realm.createObjectFromJson(Shira.class, inputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    realm.close();
                }
            }
        });
        Log.d("Realm", "createAllFromJson Shira completed");
    }
}
