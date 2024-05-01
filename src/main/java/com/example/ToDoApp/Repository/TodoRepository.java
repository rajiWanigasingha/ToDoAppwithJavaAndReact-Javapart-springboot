package com.example.ToDoApp.Repository;

import com.example.ToDoApp.ToDoModel.ToDo;
import com.example.ToDoApp.ToDoModel.Todos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TodoRepository extends MongoRepository<ToDo ,String> {}
