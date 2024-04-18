package com.example.ServiceManager.Repository;

import com.example.ServiceManager.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerRepository extends JpaRepository<Employee, Long> {

    boolean existsByName(String name);


}
