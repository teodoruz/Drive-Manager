package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.Employee;
import com.example.ServiceManager.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



@Service
public class EmplyeeService {
    @Autowired
    public EmployeeRepository employeeRepository;


    public Employee postEmployee(@RequestBody Employee employee){
        Employee emp = employeeRepository.save(employee);
        return emp;

    }

    public List<Employee> ListAllEmployees(){

        return employeeRepository.findAll();
    }

    public Employee EmployeefindEmployeeById(Long id){
       Employee resul = employeeRepository.findById(id).get();
       return resul;
    }


}
