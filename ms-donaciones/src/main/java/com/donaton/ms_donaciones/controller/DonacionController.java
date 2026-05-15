package com.donaton.ms_donaciones.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.ms_donaciones.service.DonacionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.donaton.ms_donaciones.model.Donacion;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/donaciones")
public class DonacionController {
    
    private DonacionService donacionService;

    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }
    
    @GetMapping
    public java.util.List<Donacion> listarTodas(){
        return donacionService.getDonaciones();
    }
    
    @GetMapping("/{id}")
    public Donacion buscarPorId(@PathVariable Long id){
        return donacionService.getDonacionById(id);
    }
    
    @PostMapping
    public Donacion agregarDonacion (@RequestBody Donacion donacion)
    {
        return donacionService.saveDonacion(donacion);
    }
    
    @PutMapping("/{id}")
    public Donacion editarDonacion(@RequestBody Donacion donacion) {
        return donacionService.updateDonacion(donacion);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarDonacion(@PathVariable Long id) {
        return donacionService.deleteDonacion(id);
    }
}
