package com.donaton.msDonaciones.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donaton.msDonaciones.model.Usuario;
import com.donaton.msDonaciones.service.UsuarioService;



@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        return usuarioService.getUsuarioById(id);
    }
    @PostMapping
    public Usuario agregarUsuario (@RequestBody Usuario usuario)
    {
        return usuarioService.saveUsuario(usuario);
    }
    @PutMapping("/{id}")
    public Usuario editarUsuario(@RequestBody Usuario usuario) {

        return usuarioService.updateUsuario(usuario);
    }
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        return usuarioService.deleteUsuario(id);
    }
}
