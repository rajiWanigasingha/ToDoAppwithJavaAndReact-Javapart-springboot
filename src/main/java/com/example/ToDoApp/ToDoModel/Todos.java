package com.example.ToDoApp.ToDoModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

public class Todos{
    private Integer id;
    private String title;
    private String body;
    private boolean complete;
    private LocalDate createAt;

//    Set all

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

//    get all

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean isComplete() {
        return complete;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

//    constructors

    public Todos(Integer id, String title, String body, boolean complete, LocalDate createAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.complete = complete;
        this.createAt = createAt;
    }
}
