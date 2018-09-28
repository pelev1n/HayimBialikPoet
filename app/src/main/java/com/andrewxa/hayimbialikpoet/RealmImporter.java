package com.andrewxa.hayimbialikpoet;

import android.content.res.Resources;
import android.util.Log;

import com.andrewxa.hayimbialikpoet.model.Poetry;

import java.io.InputStream;

import io.realm.Realm;


public class RealmImporter {

    static void importFromJson(final Resources resources, final int rawResourceId) {
        Realm realm = Realm.getDefaultInstance();


        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                InputStream inputStream = resources.openRawResource(rawResourceId);
                try {
                    realm.createAllFromJson(Poetry.class, inputStream);
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
