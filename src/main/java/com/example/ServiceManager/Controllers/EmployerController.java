package com.example.ServiceManager.Controllers;

import com.example.ServiceManager.Models.DTOs.EmployerDTO;
import com.example.ServiceManager.Models.Employee;
import com.example.ServiceManager.Services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employers")
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    public Employee insert(@RequestBody EmployerDTO employerDTO) throws IllegalAccessException {
        return employerService.insert(employerDTO);
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
