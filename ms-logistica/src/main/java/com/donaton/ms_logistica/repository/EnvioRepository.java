package com.example.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.logistica.model.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {

}
