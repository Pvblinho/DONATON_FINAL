package com.donaton.msDonaciones.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.donaton.msDonaciones.model.Categoria;


@Repository
public class CategoriaRepository {
   private List<Categoria> categorias = new ArrayList<>();

   public List<Categoria> listarTodos(){
       return this.categorias;
    }
    public Categoria buscarPorId(Long id){
         return this.categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);
    }
    public Categoria guardarCategoria(Categoria categoria){
         this.categorias.add(categoria);
         return categoria;
    }
    public Categoria editarCategoria(Categoria categoria){
         int index = this.categorias.indexOf(buscarPorId(categoria.getId()));
         if(index != -1){
              this.categorias.set(index, categoria);
              return categoria;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.categorias.removeIf(categoria -> categoria.getId().equals(id));
    }
}
