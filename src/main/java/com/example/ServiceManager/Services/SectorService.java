package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.DTOs.SectorDTO;
import com.example.ServiceManager.Models.CostCenter;
import com.example.ServiceManager.Repository.SectorRespository;
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

    public ResponseEntity<CostCenter> FindById(Long idSector){
    return sectorRespository.findById(idSector)
            .map(CostCenter -> ResponseEntity
            .ok()
            .body(CostCenter))
            .orElse(ResponseEntity.notFound().build());
    }

    public List<CostCenter> findAll(){
        List<CostCenter> costCenterList = sectorRespository.findAll();
        if(costCenterList.isEmpty()){
            throw new EntityNotFoundException("list empty");
        }
        return costCenterList;
    }

    public CostCenter postSector(SectorDTO sectorDTO){
        CostCenter costCenter = new CostCenter();
        costCenter.setSectorName(sectorDTO.getSectorName());
        costCenter.setIdSector(sectorDTO.getId());
        return sectorRespository.save(costCenter);
    }

    public CostCenter deleteSector(Long idSector){
        Optional<CostCenter> sectorOptional = sectorRespository.findById(idSector);
        if(sectorOptional.isPresent()){
            sectorRespository.deleteById(idSector);
            return sectorOptional.get();
        }else {
            throw new EntityNotFoundException("Entity not exist");
        }

    }

}
