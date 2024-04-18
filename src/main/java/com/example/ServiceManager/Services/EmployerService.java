package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.DTOs.EmployerDTO;
import com.example.ServiceManager.Models.Employee;
import com.example.ServiceManager.Repository.EmployerRepository;
import com.example.ServiceManager.Models.Exceptions.EmployeeNameAlreadyExists;
import com.example.ServiceManager.Models.Exceptions.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }


    public Employee insert(@RequestBody EmployerDTO employerDTO) {
        Employee employee = new Employee();
       this.toDTO(employerDTO, employee);
        try{
            return employerRepository.save(employee);
        }catch (DataIntegrityViolationException e){
            throw new EmployeeNameAlreadyExists("employee name already exists");

        }

    }
    public void toDTO(EmployerDTO employerDTO, Employee employee) {
        employee.setName(employerDTO.getName());
    }
    public List<Employee> findAll() {
        List<Employee> employee = employerRepository.findAll();
        if (employee.isEmpty()) {
            throw new EntityNotFoundException("the list is empty");
        }
        return employee;
    }

    public ResponseEntity<Employee> findById(Long id) {
        return employerRepository.findById(id)
                .map(employer -> ResponseEntity.ok()
                        .body(employer)).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Employee>> findByName(String name) {
        try {
            boolean employeeListByName = employerRepository.existsByName(name);
            if (!employeeListByName) {
                throw new EntityNotFoundException("the list is empty");
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
