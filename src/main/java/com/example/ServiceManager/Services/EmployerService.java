package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.Employer;
import com.example.ServiceManager.Repository.EmployerRepository;
import com.example.ServiceManager.Services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class EmployerService {

    @Autowired
    public EmployerRepository employerRepository;


    public Employer insert(@RequestBody Employer employer) {
        return employerRepository.save(employer);
    }

    public List<Employer> findAll() {
        List<Employer> employer = employerRepository.findAll();
        if(employer.isEmpty()){
            throw new EntityNotFoundException("the list is empty");
        }
        return employer;
    }

    public Employer findById(Long id) {
        return employerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException( id + "not found" ));
    }


}
