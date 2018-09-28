package com.andrewxa.hayimbialikpoet;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    private static final String testDbFileName = "test11db.realm";

    @Override
    public void onCreate() {
        super.onCreate();

        //Config Realm for the application
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(testDbFileName)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
