package com.example.ServiceManager.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Colaborador")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Crachá")
    private Long Id;
    @Column(name = "nome")
    private String name;
    @ManyToMany(mappedBy = "employeeList")
    private List<Task> tasks;


}
