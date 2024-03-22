package com.example.ServiceManager.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CostCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cost Center")
    private Long idSector;
    @Column(name = "Sector")
    private String sectorName;
}
