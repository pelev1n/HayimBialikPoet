package com.andrewxa.hayimbialikpoet.model;

import java.util.List;

public class Poem {

    private Integer paragraph;
    private List<String> text = null;

    public Integer getParagraph() {
        return paragraph;
    }
    public void setParagraph(Integer paragraph) {
        this.paragraph = paragraph;
    }

    public List<String> getText() {
        return text;
    }
    public void setText(List<String> text) {
        this.text = text;
    }

}