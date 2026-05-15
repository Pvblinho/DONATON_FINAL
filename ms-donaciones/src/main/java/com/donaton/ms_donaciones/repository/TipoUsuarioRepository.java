package com.donaton.ms_donaciones.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.donaton.ms_donaciones.model.TipoUsuario;


@Repository
public class TipoUsuarioRepository {
   private List<TipoUsuario> tiposUsuario = new ArrayList<>();

   public List<TipoUsuario> listarTodos(){
       return this.tiposUsuario;
    }
    public TipoUsuario buscarPorId(Long id){
         return this.tiposUsuario.stream().filter(tipo -> tipo.getId().equals(id)).findFirst().orElse(null);
    }
    public TipoUsuario guardarTipoUsuario(TipoUsuario tipoUsuario){
         this.tiposUsuario.add(tipoUsuario);
         return tipoUsuario;
    }
    public TipoUsuario editarTipoUsuario(TipoUsuario tipoUsuario){
         int index = this.tiposUsuario.indexOf(buscarPorId(tipoUsuario.getId()));
         if(index != -1){
              this.tiposUsuario.set(index, tipoUsuario);
              return tipoUsuario;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.tiposUsuario.removeIf(tipo -> tipo.getId().equals(id));
    }
}
