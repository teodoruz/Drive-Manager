package com.example.ServiceManager.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Double value;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budget")
    private List<Item> itemList;

}
