package com.andrewxa.hayimbialikpoet.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class PoemText extends RealmObject {


    private Integer paragraph;
    private RealmList<String> text = null;

    public Integer getParagraph() {
        return paragraph;
    }
    public void setParagraph(Integer paragraph) {
        this.paragraph = paragraph;
    }

    public RealmList<String> getText() {
        return text;
    }
    public void setText(RealmList<String> text) {
        this.text = text;
    }

}