package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.DTOs.TaskDTO;
import com.example.ServiceManager.Models.Employer;
import com.example.ServiceManager.Models.Task;
import com.example.ServiceManager.Repository.EmployerRepository;
import com.example.ServiceManager.Repository.TaskRepository;
import com.example.ServiceManager.Services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepository;
    @Autowired
    public EmployerRepository employerRepository;

    public List<Task> findAll(){
        List<Task> tsks = taskRepository.findAll();
        if(tsks.isEmpty()){
            throw new EntityNotFoundException("the list is empty");
        }
        return tsks;
    }

    public Task insert(@RequestBody TaskDTO taskDTO){
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setActivity(taskDTO.getActivity());
        List<Employer> listEmployer = employerRepository.findAllById(taskDTO.getEmployersIds());
        task.setEmployerList(listEmployer);
        return taskRepository.save(task);
    }
    public Task findById(Long id){
        Task resultTaks = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + "não encontrado"));
        return resultTaks;
    }
}
