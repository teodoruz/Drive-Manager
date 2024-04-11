package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.DTOs.SectorDTO;
import com.example.ServiceManager.Models.Employee;
import com.example.ServiceManager.Models.Sector;
import com.example.ServiceManager.Repository.SectorRespository;
import com.example.ServiceManager.Services.Exceptions.EmptyEntityError;
import com.example.ServiceManager.Services.Exceptions.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        List<Sector> SectorList = sectorRespository.findAll();
        if(SectorList.isEmpty()){
            throw new EntityNotFoundException("list empty");
        }else{
            return SectorList;
        }

    }

    public Sector postSector(SectorDTO sectorDTO){
        if(sectorDTO.getSectorName().isEmpty()){
            throw new EmptyEntityError("the sector field is empty");
        }else {
        Sector costCenter = new Sector();
        costCenter.setSectorName(sectorDTO.getSectorName());
        costCenter.setIdSector(sectorDTO.getId());
        return sectorRespository.save(costCenter);
            }
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

    public List<Sector> findBySectorName(String sectorName) {
        List<Sector> sectorList = sectorRespository.findBySectorNameContaining(sectorName);
        if(sectorList.isEmpty()){
            throw new EntityNotFoundException("list empty");
        }else{
            return sectorList;
        }
    }

}
