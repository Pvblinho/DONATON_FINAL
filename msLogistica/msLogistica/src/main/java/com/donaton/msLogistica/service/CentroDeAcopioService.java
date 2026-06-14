package com.donaton.msLogistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msLogistica.model.CentroDeAcopio;
import com.donaton.msLogistica.repository.CentroDeAcopioRepository;

@Service
public class CentroDeAcopioService {

   private final CentroDeAcopioRepository centroDeAcopioRepository;

   public CentroDeAcopioService(CentroDeAcopioRepository centroDeAcopioRepository) {
       this.centroDeAcopioRepository = centroDeAcopioRepository;
   }

   public List<CentroDeAcopio> getCentrosDeAcopio(){
       return centroDeAcopioRepository.findAll();
   }

   public CentroDeAcopio getCentroDeAcopioById(Long id){
       if(id != null){
           return centroDeAcopioRepository.findById(id).orElse(null);
       }
       return null;
   }

   public CentroDeAcopio saveCentroDeAcopio(CentroDeAcopio centroDeAcopio){
       return centroDeAcopioRepository.save(centroDeAcopio);
   }

   public CentroDeAcopio updateCentroDeAcopio(CentroDeAcopio centroDeAcopio){
       if(centroDeAcopio != null){
           return centroDeAcopioRepository.save(centroDeAcopio);
       }
       return null;
   }

   public String deleteCentroDeAcopio(Long id){
       if(centroDeAcopioRepository.existsById(id)){
           centroDeAcopioRepository.deleteById(id);
           return "Centro de acopio eliminado";
       }
       return "Error al eliminar el centro de acopio";
   }
}