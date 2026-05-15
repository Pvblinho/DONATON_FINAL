package com.donaton.ms_donaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.ms_donaciones.model.Categoria;
import com.donaton.ms_donaciones.repository.CategoriaRepository;

@Service
public class CategoriaService {

   private CategoriaRepository categoriaRepository;

   public CategoriaService(CategoriaRepository categoriaRepository) {
       this.categoriaRepository = categoriaRepository;
   }

   public List<Categoria> getCategorias(){
       return categoriaRepository.listarTodos();
   }

   public Categoria getCategoriaById(Long id){
       if(id != null){
           return categoriaRepository.buscarPorId(id);
       }
       return null;
   }

   public Categoria saveCategoria(Categoria categoria){
       if(categoriaRepository.buscarPorId(categoria.getId()) == null){
           return categoriaRepository.guardarCategoria(categoria);
       }
       return null;
   }

   public Categoria updateCategoria(Categoria categoria){
       if(categoria != null){
           return categoriaRepository.editarCategoria(categoria);
       }
       return null;
   }

   public String deleteCategoria(Long id){
       if(categoriaRepository.eliminarPorId(id)){
           return "Categoría eliminada";
       }
       return "Error al eliminar la categoría";
   }
}
