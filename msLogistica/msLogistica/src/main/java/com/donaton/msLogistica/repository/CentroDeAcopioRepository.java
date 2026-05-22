package com.donaton.msLogistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donaton.msLogistica.model.CentroDeAcopio;

@Repository
public interface CentroDeAcopioRepository extends JpaRepository<CentroDeAcopio, Long> {

}
