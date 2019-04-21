package com.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notebook {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String tag;
    private String text;
    private Date date;

    public Notebook(String tag, String text, Date date) {
        this.tag = tag;
        this.text = text;
        this.date = date;
    }

    public Notebook() {}

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
