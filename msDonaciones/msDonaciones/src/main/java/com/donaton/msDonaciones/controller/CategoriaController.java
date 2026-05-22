package com.donaton.msDonaciones.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.msDonaciones.model.Categoria;
import com.donaton.msDonaciones.service.CategoriaService;



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
