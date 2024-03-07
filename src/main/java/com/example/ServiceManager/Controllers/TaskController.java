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

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping
    public Task insert(@RequestBody Task task) {
        return taskService.insert(task);
    }

    @GetMapping
    public ResponseEntity<Task> findById(@PathVariable Long idTask) {
        Task result = taskService.findById(idTask);
        return ResponseEntity.ok().body(result);
    }


}






