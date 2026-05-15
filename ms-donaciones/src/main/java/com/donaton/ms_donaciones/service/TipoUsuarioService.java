package com.donaton.ms_donaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.ms_donaciones.model.TipoUsuario;
import com.donaton.ms_donaciones.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

   private TipoUsuarioRepository tipoUsuarioRepository;

   public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
       this.tipoUsuarioRepository = tipoUsuarioRepository;
   }

   public List<TipoUsuario> getTiposUsuario(){
       return tipoUsuarioRepository.listarTodos();
   }

   public TipoUsuario getTipoUsuarioById(Long id){
       if(id != null){
           return tipoUsuarioRepository.buscarPorId(id);
       }
       return null;
   }

   public TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario){
       if(tipoUsuarioRepository.buscarPorId(tipoUsuario.getId()) == null){
           return tipoUsuarioRepository.guardarTipoUsuario(tipoUsuario);
       }
       return null;
   }

   public TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario){
       if(tipoUsuario != null){
           return tipoUsuarioRepository.editarTipoUsuario(tipoUsuario);
       }
       return null;
   }

   public String deleteTipoUsuario(Long id){
       if(tipoUsuarioRepository.eliminarPorId(id)){
           return "Tipo de usuario eliminado";
       }
       return "Error al eliminar el tipo de usuario";
   }
}
