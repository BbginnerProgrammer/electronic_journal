package com.example.electronic_journal.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please fill the title")
    @Length(max = 255, message = "Title too long (more than 2kB)")
    private String title;

    @NotBlank(message = "Please fill the task")
    @Length(max = 2048, message = "Text too long (more than 2kB)")
    private String text;

    @NotBlank(message = "Please fill the object")
    @Length(max = 2048, message = "Text too long (more than 2kB)")
    private String object;

    public Tasks() {
    }

    public Tasks(String title, String text, String object) {
        this.title = title;
        this.text = text;
        this.object = object;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
