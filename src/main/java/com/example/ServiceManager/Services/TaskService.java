package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.DTOs.TaskDTO;
import com.example.ServiceManager.Models.Employee;
import com.example.ServiceManager.Models.Sector;
import com.example.ServiceManager.Models.Task;
import com.example.ServiceManager.Repository.EmployerRepository;
import com.example.ServiceManager.Repository.SectorRespository;
import com.example.ServiceManager.Repository.TaskRepository;
import com.example.ServiceManager.Models.Exceptions.EmployeeListIsNull;
import com.example.ServiceManager.Models.Exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final EmployerRepository employerRepository;
    private final SectorRespository sectorRepository;

    public TaskService(TaskRepository taskRepository, EmployerRepository employeerRepository, SectorRespository sectorRepository) {
        this.taskRepository = taskRepository;
        this.employerRepository = employeerRepository;
        this.sectorRepository = sectorRepository;
    }



    public List<Task> findAll(){
        List<Task> tsks = taskRepository.findAll();
        if(tsks.isEmpty()){
            throw new EntityNotFoundException("the list is empty");
        }
        return tsks;
    }

    public Task insert(@RequestBody TaskDTO taskDTO) throws Exception {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setActivity(taskDTO.getActivity());
        List<Long> emp = taskDTO.getEmployersIds();
        if(emp.isEmpty()){
            throw new EmployeeListIsNull("The employers list is empty");
        }else {
            List<Employee> listEmployee = employerRepository.findAllById(taskDTO.getEmployersIds());
            if(listEmployee.isEmpty()){
                throw new EntityNotFoundException("the employers " + emp + " not exist");
            }
            task.setEmployeeList(listEmployee);
        }
        Long constCenterId = taskDTO.getCostCenter();
        if(constCenterId == null){
        throw new EntityNotFoundException("the const center is empty");
        }else{
            Optional<Sector> costCenter = sectorRepository.findById(taskDTO.getCostCenter());
            if(costCenter.isEmpty()){
                throw new EntityNotFoundException("the cost center " + constCenterId + " not exist");
            }
            task.setCostCenter(costCenter.get());
        }
        return taskRepository.save(task);
    }
    public Task findById(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + "não encontrado"));
    }

    public List<Task> findByTaskName(String keyboard){
        List<Task> taskByKey = taskRepository.findByActivityContaining(keyboard);
        if(taskByKey.isEmpty()){
            throw new EntityNotFoundException("the keyboard " + keyboard + " not exist");
        }else{
            return taskByKey;
        }
    }
}
