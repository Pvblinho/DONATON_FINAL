package com.example.logistica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.logistica.service.InventarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.logistica.model.Inventario;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/inventarios")
public class InventarioController {
    
    private InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }
    
    @GetMapping
    public java.util.List<Inventario> listarTodos(){
        return inventarioService.getInventarios();
    }
    
    @GetMapping("/{id}")
    public Inventario buscarPorId(@PathVariable Long id){
        return inventarioService.getInventarioById(id);
    }
    
    @PostMapping
    public Inventario agregarInventario (@RequestBody Inventario inventario)
    {
        return inventarioService.saveInventario(inventario);
    }
    
    @PutMapping("/{id}")
    public Inventario editarInventario(@RequestBody Inventario inventario) {
        return inventarioService.updateInventario(inventario);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarInventario(@PathVariable Long id) {
        return inventarioService.deleteInventario(id);
    }
}
