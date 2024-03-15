package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.Employer;
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

    @Autowired
    public EmployerRepository employerRepository;


    public Employer insert(@RequestBody Employer employer) throws IllegalAccessException {
        if (employerRepository.existsByName(employer.getName())){
            throw new EmployeeNameAlreadyExists("funcionario ja existe");
        }
        return employerRepository.save(employer);
    }

    public List<Employer> findAll() {
        List<Employer> employer = employerRepository.findAll();
        if(employer.isEmpty()){
            throw new EntityNotFoundException("the list is empty");
        }
        return employer;
    }

    public ResponseEntity<Employer> findById(Long id) {
        return employerRepository.findById(id)
                .map(employer -> ResponseEntity.ok()
                .body(employer)).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Employer> findByName(String name){
        return null;
    }


}
