package com.andrewxa.hayimbialikpoet;

import android.app.Application;


import com.andrewxa.hayimbialikpoet.util.RealmImporter;
import com.andrewxa.hayimbialikpoet.util.Util;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    private static final String testDbFileName = "test15db.realm";

    @Override
    public void onCreate() {
        super.onCreate();

        //Config Realm for the application
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(testDbFileName)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
    }
}
