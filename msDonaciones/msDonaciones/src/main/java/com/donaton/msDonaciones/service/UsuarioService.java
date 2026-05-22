package com.donaton.msDonaciones.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msDonaciones.model.Usuario;
import com.donaton.msDonaciones.repository.UsuarioRepository;

@Service
public class UsuarioService {


   private UsuarioRepository usuarioRepository;


   public List<Usuario> getUsuarios(){
       return usuarioRepository.listarTodos();
   }


   public Usuario getUsuarioById(Long id){
       if(id != null){
           return usuarioRepository.buscarPorId(id);
       }
       return null;
   }


   public Usuario saveUsuario(Usuario usuario){
       if(usuarioRepository.buscarPorId(usuario.getId()) == null){
           return usuarioRepository.guardarUsuario(usuario);
       }
       return null;
   }


   public Usuario updateUsuario(Usuario usuario){
       if(usuario != null){
           return usuarioRepository.editarUsuario(usuario);
       }
       return null;
   }


   public String deleteUsuario(Long id){
       if(usuarioRepository.eliminarPorId(id)){
           return "Usuario eliminado";
       }
       return "Usuario no encontrado";
   }
}
