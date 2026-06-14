package com.donaton.msLogistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msLogistica.model.Inventario;
import com.donaton.msLogistica.repository.InventarioRepository;

@Service
public class InventarioService {

   private final InventarioRepository inventarioRepository;

   public InventarioService(InventarioRepository inventarioRepository) {
       this.inventarioRepository = inventarioRepository;
   }

   public List<Inventario> getInventarios(){
       return inventarioRepository.findAll();
   }

   public Inventario getInventarioById(Long id){
       if(id != null){
           return inventarioRepository.findById(id).orElse(null);
       }
       return null;
   }

   public Inventario saveInventario(Inventario inventario){
       return inventarioRepository.save(inventario);
   }

   public Inventario updateInventario(Inventario inventario){
       if(inventario != null){
           return inventarioRepository.save(inventario);
       }
       return null;
   }

   public String deleteInventario(Long id){
       if(inventarioRepository.existsById(id)){
           inventarioRepository.deleteById(id);
           return "Inventario eliminado";
       }
       return "Error al eliminar el inventario";
   }
}