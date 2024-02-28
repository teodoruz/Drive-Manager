package com.example.ServiceManager.Controllers;

import com.example.ServiceManager.Models.Employee;
import com.example.ServiceManager.Services.EmplyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    public EmplyeeService emplyeeService;

    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee){
        return emplyeeService.postEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        return emplyeeService.ListAllEmployees();
    }
    @GetMapping("/{idEmp}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long idEmp){
        Employee emp = emplyeeService.EmployeefindEmployeeById(idEmp);
        return ResponseEntity.ok().body(emp);
    }
}
