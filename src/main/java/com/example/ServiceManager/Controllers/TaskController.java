package com.example.ServiceManager.Controllers;

import com.example.ServiceManager.Models.Task;
import com.example.ServiceManager.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping(value = "findAllT")
    public List<Task> allTasks() {
        return taskService.allTasks();
    }


    @PostMapping(value = "/postTask")
    public Task postNewTask(@RequestBody Task task) {
        return taskService.postNewTask(task);
    }

//    @GetMapping("/return/{id}")
//    public Task findTAsById(@RequestParam Long id){
//        Task tasks = taskService.findTaskById(id);
//        return tasks;
//    }
    @GetMapping("/find/{idTask}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long idTask){
        Task result = taskService.findTaskById(idTask);
        return ResponseEntity.ok().body(result);
    }
}






