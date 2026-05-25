package com.donaton.msLogistica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.msLogistica.model.Necesidad;
import com.donaton.msLogistica.service.NecesidadService;

@RestController
@RequestMapping("/api/v1/necesidades")
public class NecesidadController {

    private final NecesidadService necesidadService;

    public NecesidadController(NecesidadService necesidadService) {
        this.necesidadService = necesidadService;
    }

    @GetMapping
    public List<Necesidad> listarTodos() {
        return necesidadService.getNecesidades();
    }

    @GetMapping("/{id}")
    public Necesidad buscarPorId(@PathVariable Long id) {
        return necesidadService.getNecesidadById(id);
    }

    @PostMapping
    public Necesidad agregar(@RequestBody Necesidad necesidad) {
        return necesidadService.saveNecesidad(necesidad);
    }

    @PutMapping("/{id}")
    public Necesidad editar(@RequestBody Necesidad necesidad, @PathVariable Long id) {
        return necesidadService.updateNecesidad(id, necesidad);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return necesidadService.deleteNecesidad(id);
    }
}
