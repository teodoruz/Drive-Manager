package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.Task;
import com.example.ServiceManager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task insert(@RequestBody Task task){
        Task newTask = taskRepository.save(task);
        return newTask;
    }
    public Task findById(Long id){
        Task resultTaks = taskRepository.findById(id).get();
        return resultTaks;
    }
}
