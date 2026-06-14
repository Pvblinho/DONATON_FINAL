package com.donaton.msLogistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msLogistica.model.Transporte;
import com.donaton.msLogistica.repository.TransporteRepository;

@Service
public class TransporteService {

   private final TransporteRepository transporteRepository;

   public TransporteService(TransporteRepository transporteRepository) {
       this.transporteRepository = transporteRepository;
   }

   public List<Transporte> getTransportes(){
       return transporteRepository.findAll();
   }

   public Transporte getTransporteById(Long id){
       if(id != null){
           return transporteRepository.findById(id).orElse(null);
       }
       return null;
   }

   public Transporte saveTransporte(Transporte transporte){
       return transporteRepository.save(transporte);
   }

   public Transporte updateTransporte(Transporte transporte){
       if(transporte != null){
           return transporteRepository.save(transporte);
       }
       return null;
   }

   public String deleteTransporte(Long id){
       if(transporteRepository.existsById(id)){
           transporteRepository.deleteById(id);
           return "Transporte eliminado";
       }
       return "Error al eliminar el transporte";
   }
}
