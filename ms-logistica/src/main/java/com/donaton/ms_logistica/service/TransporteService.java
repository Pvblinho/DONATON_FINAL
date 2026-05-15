package com.example.logistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.logistica.model.Transporte;
import com.example.logistica.repository.TransporteRepository;

@Service
public class TransporteService {

   private TransporteRepository transporteRepository;

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
