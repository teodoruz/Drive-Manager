package com.example.ServiceManager.Repository;

import com.example.ServiceManager.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
