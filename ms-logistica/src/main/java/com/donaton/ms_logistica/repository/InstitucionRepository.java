package com.donaton.ms_logistica.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.donaton.ms_logistica.model.Institucion;


@Repository
public class InstitucionRepository {
   private List<Institucion> instituciones = new ArrayList<>();

   public List<Institucion> listarTodos(){
       return this.instituciones;
    }
    public Institucion buscarPorId(Long id){
         return this.instituciones.stream().filter(institucion -> institucion.getId().equals(id)).findFirst().orElse(null);
    }
    public Institucion guardarInstitucion(Institucion institucion){
         this.instituciones.add(institucion);
         return institucion;
    }
    public Institucion editarInstitucion(Institucion institucion){
         int index = this.instituciones.indexOf(buscarPorId(institucion.getId()));
         if(index != -1){
              this.instituciones.set(index, institucion);
              return institucion;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.instituciones.removeIf(institucion -> institucion.getId().equals(id));
    }
}
