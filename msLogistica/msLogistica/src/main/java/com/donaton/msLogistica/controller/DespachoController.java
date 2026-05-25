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

import com.donaton.msLogistica.model.Despacho;
import com.donaton.msLogistica.service.DespachoService;

@RestController
@RequestMapping("/api/v1/despachos")
public class DespachoController {

    private final DespachoService despachoService;

    public DespachoController(DespachoService despachoService) {
        this.despachoService = despachoService;
    }

    @GetMapping
    public List<Despacho> listarTodos() {
        return despachoService.getDespachos();
    }

    @GetMapping("/{id}")
    public Despacho buscarPorId(@PathVariable Long id) {
        return despachoService.getDespachoById(id);
    }

    @PostMapping
    public Despacho agregar(@RequestBody Despacho despacho) {
        return despachoService.saveDespacho(despacho);
    }

    @PutMapping("/{id}")
    public Despacho editar(@RequestBody Despacho despacho, @PathVariable Long id) {
        return despachoService.updateDespacho(id, despacho);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return despachoService.deleteDespacho(id);
    }
}
