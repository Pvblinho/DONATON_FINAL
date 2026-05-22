package com.donaton.msLogistica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.msLogistica.service.CentroDeAcopioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.donaton.msLogistica.model.CentroDeAcopio;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/centros-de-acopio")
public class CentroDeAcopioController {
    
    private CentroDeAcopioService centroDeAcopioService;

    public CentroDeAcopioController(CentroDeAcopioService centroDeAcopioService) {
        this.centroDeAcopioService = centroDeAcopioService;
    }
    
    @GetMapping
    public java.util.List<CentroDeAcopio> listarTodos(){
        return centroDeAcopioService.getCentrosDeAcopio();
    }
    
    @GetMapping("/{id}")
    public CentroDeAcopio buscarPorId(@PathVariable Long id){
        return centroDeAcopioService.getCentroDeAcopioById(id);
    }
    
    @PostMapping
    public CentroDeAcopio agregarCentroDeAcopio (@RequestBody CentroDeAcopio centroDeAcopio)
    {
        return centroDeAcopioService.saveCentroDeAcopio(centroDeAcopio);
    }
    
    @PutMapping("/{id}")
    public CentroDeAcopio editarCentroDeAcopio(@RequestBody CentroDeAcopio centroDeAcopio) {
        return centroDeAcopioService.updateCentroDeAcopio(centroDeAcopio);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarCentroDeAcopio(@PathVariable Long id) {
        return centroDeAcopioService.deleteCentroDeAcopio(id);
    }
}
