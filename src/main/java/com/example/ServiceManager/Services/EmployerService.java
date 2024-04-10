package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.Employee;
import com.example.ServiceManager.Repository.EmployerRepository;
import com.example.ServiceManager.Services.Exceptions.EmployeeNameAlreadyExists;
import com.example.ServiceManager.Services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository){
        this.employerRepository = employerRepository;
    }


    public Employee insert(@RequestBody Employee employee) throws IllegalAccessException {
        if (employerRepository.existsByName(employee.getName())){
            throw new EmployeeNameAlreadyExists("funcionario ja existe");
        }
        return employerRepository.save(employee);
    }

    public List<Employee> findAll() {
        List<Employee> employee = employerRepository.findAll();
        if(employee.isEmpty()){
            throw new EntityNotFoundException("the list is empty");
        }
        return employee;
    }

    public ResponseEntity<Employee> findById(Long id) {
        return employerRepository.findById(id)
                .map(employer -> ResponseEntity.ok()
                .body(employer)).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Employee> findByName(String name){
        return null;
    }


}
