package com.andrewxa.hayimbialikpoet.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Shira  extends RealmObject {

    @PrimaryKey
    private String type;
    private RealmList<Poem> poems = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RealmList<Poem> getPoems() {
        return poems;
    }

    public void setPoems(RealmList<Poem> poems) {
        this.poems = poems;
    }
}
