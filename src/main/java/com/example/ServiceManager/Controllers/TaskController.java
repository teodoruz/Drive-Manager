package com.example.ServiceManager.Controllers;

import com.example.ServiceManager.Models.DTOs.TaskDTO;
import com.example.ServiceManager.Models.Task;
import com.example.ServiceManager.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> findAll() {
        List<Task> result = taskService.findAll();
        return result;
    }

    @PostMapping
    public ResponseEntity<Task> insert(@RequestBody TaskDTO taskDTO) throws Exception {
        Task tsk = taskService.insert(taskDTO);
        return ResponseEntity.ok(tsk);
    }

    @GetMapping("/{idTask}")
    public ResponseEntity<Task> findById(@PathVariable Long idTask) {
        Task result = taskService.findById(idTask);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/find")
    public List<Task> findTaskByName(@RequestParam String keyboard) {
        return taskService.findByTaskName(keyboard);
    }


}






