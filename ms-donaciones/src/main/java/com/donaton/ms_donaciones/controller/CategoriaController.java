package com.donaton.ms_donaciones.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.ms_donaciones.service.CategoriaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.donaton.ms_donaciones.model.Categoria;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
    
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    @GetMapping
    public java.util.List<Categoria> listarTodas(){
        return categoriaService.getCategorias();
    }
    
    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id){
        return categoriaService.getCategoriaById(id);
    }
    
    @PostMapping
    public Categoria agregarCategoria (@RequestBody Categoria categoria)
    {
        return categoriaService.saveCategoria(categoria);
    }
    
    @PutMapping("/{id}")
    public Categoria editarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(categoria);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        return categoriaService.deleteCategoria(id);
    }
}
