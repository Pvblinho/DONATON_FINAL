package com.donaton.ms_logistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.ms_logistica.model.Necesidad;
import com.donaton.ms_logistica.repository.NecesidadRepository;

@Service
public class NecesidadService {

   private NecesidadRepository necesidadRepository;

   public NecesidadService(NecesidadRepository necesidadRepository) {
       this.necesidadRepository = necesidadRepository;
   }

   public List<Necesidad> getNecesidades(){
       return necesidadRepository.listarTodos();
   }

   public Necesidad getNecesidadById(Long id){
       if(id != null){
           return necesidadRepository.buscarPorId(id);
       }
       return null;
   }

   public Necesidad saveNecesidad(Necesidad necesidad){
       if(necesidadRepository.buscarPorId(necesidad.getId()) == null){
           return necesidadRepository.guardarNecesidad(necesidad);
       }
       return null;
   }

   public Necesidad updateNecesidad(Necesidad necesidad){
       if(necesidad != null){
           return necesidadRepository.editarNecesidad(necesidad);
       }
       return null;
   }

   public String deleteNecesidad(Long id){
       if(necesidadRepository.eliminarPorId(id)){
           return "Necesidad eliminada";
       }
       return "Error al eliminar la necesidad";
   }
}
