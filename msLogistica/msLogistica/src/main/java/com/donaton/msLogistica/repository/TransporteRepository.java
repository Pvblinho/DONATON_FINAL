package com.donaton.msLogistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donaton.msLogistica.model.Transporte;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {

}
