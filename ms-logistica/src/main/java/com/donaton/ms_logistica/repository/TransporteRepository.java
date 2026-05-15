package com.example.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.logistica.model.Transporte;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {

}
