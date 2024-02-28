package com.example.ServiceManager.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Table(name = "Tarefa")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Tarefa")
    private String activity;
    @ManyToMany
    @JoinTable(name = "emplyees_in_task", joinColumns = @JoinColumn(name = "Task_Id"),
    inverseJoinColumns = @JoinColumn(name = "Employee_Id"))
    private List<Employee> employeeList;



}
