package com.donaton.msLogistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donaton.msLogistica.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

}
