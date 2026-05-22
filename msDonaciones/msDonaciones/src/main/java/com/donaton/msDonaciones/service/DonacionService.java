package com.donaton.msDonaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msDonaciones.model.Donacion;
import com.donaton.msDonaciones.repository.DonacionRepository;

@Service
public class DonacionService {

   private DonacionRepository donacionRepository;

   public DonacionService(DonacionRepository donacionRepository) {
       this.donacionRepository = donacionRepository;
   }

   public List<Donacion> getDonaciones(){
       return donacionRepository.listarTodos();
   }

   public Donacion getDonacionById(Long id){
       if(id != null){
           return donacionRepository.buscarPorId(id);
       }
       return null;
   }

   public Donacion saveDonacion(Donacion donacion){
       if(donacionRepository.buscarPorId(donacion.getId()) == null){
           return donacionRepository.guardarDonacion(donacion);
       }
       return null;
   }

   public Donacion updateDonacion(Donacion donacion){
       if(donacion != null){
           return donacionRepository.editarDonacion(donacion);
       }
       return null;
   }

   public String deleteDonacion(Long id){
       if(donacionRepository.eliminarPorId(id)){
           return "Donación eliminada";
       }
       return "Error al eliminar la donación";
   }
}
