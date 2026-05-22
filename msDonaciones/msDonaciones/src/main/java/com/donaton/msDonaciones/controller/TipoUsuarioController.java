package com.donaton.msDonaciones.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.msDonaciones.model.TipoUsuario;
import com.donaton.msDonaciones.service.TipoUsuarioService;



@RestController
@RequestMapping("/api/v1/tipos-usuario")
public class TipoUsuarioController {
    
    private TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }
    
    @GetMapping
    public java.util.List<TipoUsuario> listarTodos(){
        return tipoUsuarioService.getTiposUsuario();
    }
    
    @GetMapping("/{id}")
    public TipoUsuario buscarPorId(@PathVariable Long id){
        return tipoUsuarioService.getTipoUsuarioById(id);
    }
    
    @PostMapping
    public TipoUsuario agregarTipoUsuario (@RequestBody TipoUsuario tipoUsuario)
    {
        return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
    }
    
    @PutMapping("/{id}")
    public TipoUsuario editarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.updateTipoUsuario(tipoUsuario);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarTipoUsuario(@PathVariable Long id) {
        return tipoUsuarioService.deleteTipoUsuario(id);
    }
}
