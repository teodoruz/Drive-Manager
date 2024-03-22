package com.example.ServiceManager.Repository;

import com.example.ServiceManager.Models.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRespository extends JpaRepository<CostCenter, Long> {
}
