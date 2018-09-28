package com.andrewxa.hayimbialikpoet.model;

import java.util.List;

public class Poetry {

    private Integer id;
    private String type;
    private String date;
    private String title;
    private String titleAggl;
    private List<Poem> poem = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<Poem> getPoem() {
        return poem;
    }

    public void setPoem(List<Poem> poem) {
        this.poem = poem;
    }

}
