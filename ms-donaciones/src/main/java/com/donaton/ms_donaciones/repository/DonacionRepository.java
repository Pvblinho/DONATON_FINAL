package com.donaton.ms_donaciones.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.donaton.ms_donaciones.model.Donacion;


@Repository
public class DonacionRepository {
   private List<Donacion> donaciones = new ArrayList<>();

   public List<Donacion> listarTodos(){
       return this.donaciones;
    }
    public Donacion buscarPorId(Long id){
         return this.donaciones.stream().filter(donacion -> donacion.getId().equals(id)).findFirst().orElse(null);
    }
    public Donacion guardarDonacion(Donacion donacion){
         this.donaciones.add(donacion);
         return donacion;
    }
    public Donacion editarDonacion(Donacion donacion){
         int index = this.donaciones.indexOf(buscarPorId(donacion.getId()));
         if(index != -1){
              this.donaciones.set(index, donacion);
              return donacion;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.donaciones.removeIf(donacion -> donacion.getId().equals(id));
    }
}
