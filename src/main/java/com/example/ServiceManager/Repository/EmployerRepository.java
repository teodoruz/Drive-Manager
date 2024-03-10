package com.example.ServiceManager.Repository;

import com.example.ServiceManager.Models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    boolean existsByName(String name);
}
