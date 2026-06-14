package com.donaton.msLogistica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.msLogistica.model.Envio;
import com.donaton.msLogistica.service.EnvioService;



@RestController
@RequestMapping("/api/v1/envios")
public class EnvioController {
    
    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }
    
    @GetMapping
    public java.util.List<Envio> listarTodos(){
        return envioService.getEnvios();
    }
    
    @GetMapping("/{id}")
    public Envio buscarPorId(@PathVariable Long id){
        return envioService.getEnvioById(id);
    }
    
    @PostMapping
    public Envio agregarEnvio (@RequestBody Envio envio)
    {
        return envioService.saveEnvio(envio);
    }
    
    @PutMapping("/{id}")
    public Envio editarEnvio(@RequestBody Envio envio) {
        return envioService.updateEnvio(envio);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarEnvio(@PathVariable Long id) {
        return envioService.deleteEnvio(id);
    }
}
