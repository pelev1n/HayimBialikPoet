package com.andrewxa.hayimbialikpoet.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Poem extends RealmObject {

    private Integer id;
    private String date;
    private String title;
    private String titleAggl;
    private RealmList<PoemText> poemText = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleAggl() {
        return titleAggl;
    }

    public void setTitleAggl(String titleAggl) {
        this.titleAggl = titleAggl;
    }

    public RealmList<PoemText> getPoemText() {
        return poemText;
    }

    public void setPoemText(RealmList<PoemText> poemText) {
        this.poemText = poemText;
    }

}