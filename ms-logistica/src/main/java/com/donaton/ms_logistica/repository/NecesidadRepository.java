package com.donaton.ms_logistica.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.donaton.ms_logistica.model.Necesidad;


@Repository
public class NecesidadRepository {
   private List<Necesidad> necesidades = new ArrayList<>();

   public List<Necesidad> listarTodos(){
       return this.necesidades;
    }
    public Necesidad buscarPorId(Long id){
         return this.necesidades.stream().filter(necesidad -> necesidad.getId().equals(id)).findFirst().orElse(null);
    }
    public Necesidad guardarNecesidad(Necesidad necesidad){
         this.necesidades.add(necesidad);
         return necesidad;
    }
    public Necesidad editarNecesidad(Necesidad necesidad){
         int index = this.necesidades.indexOf(buscarPorId(necesidad.getId()));
         if(index != -1){
              this.necesidades.set(index, necesidad);
              return necesidad;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.necesidades.removeIf(necesidad -> necesidad.getId().equals(id));
    }
}
