package com.donaton.msLogistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msLogistica.model.Envio;
import com.donaton.msLogistica.repository.EnvioRepository;

@Service
public class EnvioService {

   private EnvioRepository envioRepository;

   public EnvioService(EnvioRepository envioRepository) {
       this.envioRepository = envioRepository;
   }

   public List<Envio> getEnvios(){
       return envioRepository.findAll();
   }

   public Envio getEnvioById(Long id){
       if(id != null){
           return envioRepository.findById(id).orElse(null);
       }
       return null;
   }

   public Envio saveEnvio(Envio envio){
       return envioRepository.save(envio);
   }

   public Envio updateEnvio(Envio envio){
       if(envio != null){
           return envioRepository.save(envio);
       }
       return null;
   }

   public String deleteEnvio(Long id){
       if(envioRepository.existsById(id)){
           envioRepository.deleteById(id);
           return "Envío eliminado";
       }
       return "Error al eliminar el envío";
   }
}
