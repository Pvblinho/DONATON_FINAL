package com.donaton.msLogistica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.msLogistica.model.Transporte;
import com.donaton.msLogistica.service.TransporteService;


@RestController
@RequestMapping("/api/v1/transportes")
public class TransporteController {
    
    private final TransporteService transporteService;

    public TransporteController(TransporteService transporteService) {
        this.transporteService = transporteService;
    }
    
    @GetMapping
    public java.util.List<Transporte> listarTodos(){
        return transporteService.getTransportes();
    }
    
    @GetMapping("/{id}")
    public Transporte buscarPorId(@PathVariable Long id){
        return transporteService.getTransporteById(id);
    }
    
    @PostMapping
    public Transporte agregarTransporte (@RequestBody Transporte transporte)
    {
        return transporteService.saveTransporte(transporte);
    }
    
    @PutMapping("/{id}")
    public Transporte editarTransporte(@RequestBody Transporte transporte) {
        return transporteService.updateTransporte(transporte);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarTransporte(@PathVariable Long id) {
        return transporteService.deleteTransporte(id);
    }
}
