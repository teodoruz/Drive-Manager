package com.example.ServiceManager.Controllers;

import com.example.ServiceManager.Models.DTOs.SectorDTO;
import com.example.ServiceManager.Models.Sector;
import com.example.ServiceManager.Repository.SectorRespository;
import com.example.ServiceManager.Services.Exceptions.EntityNotFoundException;
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
    public ResponseEntity<Sector> findById(@PathVariable Long idSector){
        return sectorService.FindById(idSector);
    }
    @GetMapping
    public List<Sector> findAll(){
        List<Sector> sectorList = sectorService.findAll();
        return sectorList;
    }
    @PostMapping
    public Sector epostSector(@RequestBody SectorDTO sectorDTO){
        Sector sector = sectorService.postSector(sectorDTO);
        return sector;
    }
    @PutMapping("/{idSector}")
    public Sector putSector(@PathVariable Long idSector){
        return sectorService.deleteSector(idSector);
    }
}
