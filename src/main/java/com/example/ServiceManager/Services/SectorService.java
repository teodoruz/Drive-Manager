package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.Sector;
import com.example.ServiceManager.Repository.SectorRespository;
import com.example.ServiceManager.Services.Exceptions.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService {
    private final SectorRespository sectorRespository;
    public SectorService(SectorRespository sectorRespository){
        this.sectorRespository =sectorRespository;
    }

    public ResponseEntity<Sector> FindById(Long idSector){
    return sectorRespository.findById(idSector)
            .map(Sector -> ResponseEntity
            .ok()
            .body(Sector))
            .orElse(ResponseEntity.notFound().build());

    }

}
