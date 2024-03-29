package com.example.ServiceManager.Controllers;

import com.example.ServiceManager.Models.Employee;
import com.example.ServiceManager.Services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employers")
public class EmployerController {

    @Autowired
    public EmployerService employerService;

    @PostMapping
    public Employee insert(@RequestBody Employee employee) throws IllegalAccessException {
        return employerService.insert(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        return employerService.findAll();
    }
    @GetMapping("/{idEmployer}")
    public ResponseEntity<Employee> findById(@PathVariable Long idEmployer){
        return employerService.findById(idEmployer);

    }
}
