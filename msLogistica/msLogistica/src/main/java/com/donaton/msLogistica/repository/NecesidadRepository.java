package com.donaton.msLogistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donaton.msLogistica.model.Necesidad;

@Repository
public interface NecesidadRepository extends JpaRepository<Necesidad, Long> {

}
