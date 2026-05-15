package com.donaton.ms_donaciones.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.donaton.ms_donaciones.model.Usuario;


@Repository
public class UsuarioRepository {
   private List<Usuario> usuarios = new ArrayList<>();

   public List<Usuario> listarTodos(){
       return this.usuarios;
    }
    public Usuario buscarPorId(Long id){
         return this.usuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst().orElse(null);
    }
    public Usuario guardarUsuario(Usuario usuario){
         this.usuarios.add(usuario);
         return usuario;
    }
    public Usuario editarUsuario(Usuario usuario){
         int index = this.usuarios.indexOf(buscarPorId(usuario.getId()));
         if(index != -1){
              this.usuarios.set(index, usuario);
              return usuario;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}

