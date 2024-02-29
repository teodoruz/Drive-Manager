package com.example.ServiceManager.Controllers;

import com.example.ServiceManager.Models.Employer;
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
    public Employer insert(@RequestBody Employer employer){
        return employerService.insert(employer);
    }

    @GetMapping
    public List<Employer> findAll(){
        return employerService.findAll();
    }
    @GetMapping("/{idEmployer}")
    public ResponseEntity<Employer> findById(@PathVariable Long idEmployer){
        Employer resultEmployer = employerService.findById(idEmployer);
        return ResponseEntity.ok().body(resultEmployer);
    }
}
