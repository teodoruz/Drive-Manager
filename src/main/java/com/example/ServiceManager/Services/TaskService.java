package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.Task;
import com.example.ServiceManager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepository;

    public List<Task> allTasks(){

        return taskRepository.findAll();
    }

    public Task postNewTask(@RequestBody Task task){
        Task tsk = taskRepository.save(task);
        return tsk;
    }
    public Task findTaskById(Long id){
        Task tasksId = taskRepository.findById(id).get();
        return tasksId;
    }
}
