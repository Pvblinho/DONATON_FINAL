package com.example.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.logistica.model.CentroDeAcopio;

@Repository
public interface CentroDeAcopioRepository extends JpaRepository<CentroDeAcopio, Long> {

}
