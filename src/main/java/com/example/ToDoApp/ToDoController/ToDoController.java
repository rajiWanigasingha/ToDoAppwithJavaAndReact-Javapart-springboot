package com.example.ToDoApp.ToDoController;

import com.example.ToDoApp.ToDoModel.*;
import com.example.ToDoApp.ToDoService.ToDoService;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/" ,allowedHeaders = "*")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }


//    Get all Task
    @GetMapping("/getAllTask")
    public List<ToDo> getAllTask(){
        return toDoService.getAllTask();
    }

//    Get a single task with todos
    @GetMapping("/getSingleTask/{taskId}")
    public Optional<ToDo> getSingleTaskById(@PathVariable String taskId){
        return toDoService.getSingleTaskById(taskId);
    }

//    Create task
    @PostMapping("/createTask")
    public ToDo createTask(@RequestBody ToDo toDo){
        return toDoService.createTask(toDo);
    }

//    Create todos in that task
    @PostMapping("/createToDo/{taskId}")
    public ToDo createToDo(@RequestBody Todos todos,@PathVariable String taskId){
        todos.setId(new Random().nextInt(Integer.MAX_VALUE));
        return toDoService.createToDo(todos,taskId);
    }

//    Complete task
    @DeleteMapping("/deleteTask/{id}")
    public Map<String ,String> deleteTask(@PathVariable String id){
        return toDoService.deleteTask(id);
    }

//    Complete todos
    @PostMapping("/completeToDo/{taskId}")
    public ToDo completeToDo(@RequestBody Todos todos,@PathVariable String taskId){
        return toDoService.completeToDo(todos,taskId);
    }

}
