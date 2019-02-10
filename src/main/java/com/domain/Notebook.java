package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notebook {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String tag;
    private String text;

    public Notebook() {
    }

    public Notebook(String tag, String text) {
        this.tag = tag;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
