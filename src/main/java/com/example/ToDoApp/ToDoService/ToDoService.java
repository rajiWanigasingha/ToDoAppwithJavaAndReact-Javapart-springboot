package com.example.ToDoApp.ToDoService;

import com.example.ToDoApp.Repository.TodoRepository;
import com.example.ToDoApp.ToDoModel.ToDo;
import com.example.ToDoApp.ToDoModel.Todos;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ToDoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<ToDo> getAllTask(){
        return todoRepository.findAll();
    }

    public Optional<ToDo> getSingleTaskById(String taskId){
        return todoRepository.findById(taskId);
    }

    public ToDo createTask(ToDo toDo){
        ObjectId objectId = new ObjectId();
        toDo.setId(objectId.toString());
        return todoRepository.insert(toDo);
    }

    public ToDo createToDo(Todos todos, String id){
        ToDo toDo = todoRepository.findById(id).orElse(null);

        if(toDo == null){
            throw new IllegalArgumentException("Invalid id please try another Id");
        }else{
            List<Todos> existToDo = toDo.getTodos();
            existToDo.add(todos);
            toDo.setTodos(existToDo);
            return todoRepository.save(toDo);
        }
    }

    public Map<String ,String> deleteTask(String id){
        try {
            todoRepository.deleteById(id);
            return new HashMap<>(){{put("Message","success");}};
        } catch (EmptyResultDataAccessException e){
            return new HashMap<>() {{
                put("Error", "Entity with ID " + id + " not found");
            }};
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ToDo completeToDo(Todos todos ,String id){
        ToDo toDo = todoRepository.findById(id).orElse(null);

        if (toDo == null){
            throw new IllegalArgumentException("invalid task id");
        }else {
            List<Todos> todosList = toDo.getTodos();
            todosList.forEach(todos1 -> {
                if(Objects.equals(todos1.getId(), todos.getId())){
                    todos1.setComplete(todos.isComplete());
                }
            });
            toDo.setTodos(todosList);
            return todoRepository.save(toDo);
        }
    }

}
