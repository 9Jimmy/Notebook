package com.domain;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.Date;
=======
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
>>>>>>> 41bfb2a3f35bd6948124586c47d16bbd4a567ac1

@Entity
@Data
@RequiredArgsConstructor
public class Notebook {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String tag;
    private String text;
    private Date date;

<<<<<<< HEAD
    public Notebook(String tag, String text, Date date) {
=======
    public Notebook(String tag, String text) {
>>>>>>> 41bfb2a3f35bd6948124586c47d16bbd4a567ac1
        this.tag = tag;
        this.text = text;
        this.date = date;
    }

<<<<<<< HEAD
    public Notebook() {}
=======
    /*public Notebook() {}
>>>>>>> 41bfb2a3f35bd6948124586c47d16bbd4a567ac1

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
    }*/
}
