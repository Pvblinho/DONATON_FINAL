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

import com.donaton.msLogistica.model.Institucion;
import com.donaton.msLogistica.service.InstitucionService;

@RestController
@RequestMapping("/api/v1/instituciones")
public class InstitucionController {

    private final InstitucionService institucionService;

    public InstitucionController(InstitucionService institucionService) {
        this.institucionService = institucionService;
    }

    @GetMapping
    public List<Institucion> listarTodos() {
        return institucionService.getInstituciones();
    }

    @GetMapping("/{id}")
    public Institucion buscarPorId(@PathVariable Long id) {
        return institucionService.getInstitucionById(id);
    }

    @PostMapping
    public Institucion agregar(@RequestBody Institucion institucion) {
        return institucionService.saveInstitucion(institucion);
    }

    @PutMapping("/{id}")
    public Institucion editar(@RequestBody Institucion institucion, @PathVariable Long id) {
        return institucionService.updateInstitucion(id, institucion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return institucionService.deleteInstitucion(id);
    }
}
