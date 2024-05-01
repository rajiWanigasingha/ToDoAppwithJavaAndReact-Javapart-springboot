package com.example.ToDoApp.ToDoModel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "todoTask")
public class ToDo {

    @Id
    private String id;

    private String taskName;

    private List<Todos> todos;

//    set all

    public void setId(String id) {
        this.id = id;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTodos(List<Todos> todos) {
        this.todos = todos;
    }

//    get all

    public String getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public List<Todos> getTodos() {
        return todos;
    }


//    constructors


    public ToDo(String id, String taskName, List<Todos> todos) {
        this.id = id;
        this.taskName = taskName;
        this.todos = todos;
    }
}

