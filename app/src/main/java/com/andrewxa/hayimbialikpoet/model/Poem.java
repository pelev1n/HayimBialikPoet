package com.andrewxa.hayimbialikpoet.model;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class Poem extends RealmObject {

    private Integer paragraph;
    private RealmList<String> text = null;

    public Integer getParagraph() {
        return paragraph;
    }
    public void setParagraph(Integer paragraph) {
        this.paragraph = paragraph;
    }

    public List<String> getText() {
        return text;
    }
    public void setText(RealmList<String> text) {
        this.text = text;
    }

}