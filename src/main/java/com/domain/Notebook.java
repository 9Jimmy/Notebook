package com.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Notebook {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String tag;
    private String text;

    public Notebook() {
    }

    public Notebook(String tag, String text) {
        this.tag = tag;
        this.text = text;
    }
}
