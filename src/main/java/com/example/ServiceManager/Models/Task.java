package com.example.ServiceManager.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.reflect.IReflectionWorld;

import java.util.List;

@AllArgsConstructor
@Table(name = "task")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "description")
    private String activity;
    @ManyToMany
    @JoinTable(name = "employer_task", joinColumns = @JoinColumn(name = "task_id"),
    inverseJoinColumns = @JoinColumn(name = "employer_id"))
    @Column(name = "employers")
    private List<Employee> employeeList;
    @ManyToOne
    @JoinColumn(name = "CostCenterId")
    private Sector costCenter;
    @OneToMany
    @Column(name = "Item")
    private List<Item> itemList;
}
