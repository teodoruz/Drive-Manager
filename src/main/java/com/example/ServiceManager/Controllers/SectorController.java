package com.example.ServiceManager.Controllers;

import com.example.ServiceManager.Models.DTOs.SectorDTO;
import com.example.ServiceManager.Models.CostCenter;
import com.example.ServiceManager.Services.SectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sector")
public class SectorController {

    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/{idSector}")
    public ResponseEntity<CostCenter> findById(@PathVariable Long idSector){
        return sectorService.FindById(idSector);
    }
    @GetMapping
    public List<CostCenter> findAll(){
        List<CostCenter> costCenterList = sectorService.findAll();
        return costCenterList;
    }
    @PostMapping
    public CostCenter epostSector(@RequestBody SectorDTO sectorDTO){
        CostCenter costCenter = sectorService.postSector(sectorDTO);
        return costCenter;
    }
    @PutMapping("/{idSector}")
    public CostCenter putSector(@PathVariable Long idSector){
        return sectorService.deleteSector(idSector);
    }
}
