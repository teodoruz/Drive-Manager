package com.example.ServiceManager.Repository;
import com.example.ServiceManager.Models.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRespository extends JpaRepository<Sector, Long> {

    List<Sector> findBySectorNameContaining(String name);
}
