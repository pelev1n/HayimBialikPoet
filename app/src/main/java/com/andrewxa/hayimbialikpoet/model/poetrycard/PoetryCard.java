package com.andrewxa.hayimbialikpoet.model.poetrycard;

public class PoetryCard {
    private String title;
    private int thumbnail;

    public PoetryCard() {

    }

    public PoetryCard(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
