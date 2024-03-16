package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.DTOs.SectorDTO;
import com.example.ServiceManager.Models.Sector;
import com.example.ServiceManager.Repository.SectorRespository;
import com.example.ServiceManager.Services.Exceptions.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public List<Sector> findAll(){
        List<Sector> sectorList = sectorRespository.findAll();
        if(sectorList.isEmpty()){
            throw new EntityNotFoundException("list empty");
        }
        return sectorList;
    }

    public Sector postSector(SectorDTO sectorDTO){
        Sector sector = new Sector();
        sector.setSectorName(sectorDTO.getSectorName());
        sector.setIdSector(sectorDTO.getId());
        return sectorRespository.save(sector);
    }

    public Sector deleteSector(Long idSector){
        Optional<Sector> sectorOptional = sectorRespository.findById(idSector);
        if(sectorOptional.isPresent()){
            sectorRespository.deleteById(idSector);
            return sectorOptional.get();
        }else {
            throw new EntityNotFoundException("Entity not exist");
        }

    }

}
