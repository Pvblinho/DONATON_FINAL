package com.example.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.logistica.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

}
