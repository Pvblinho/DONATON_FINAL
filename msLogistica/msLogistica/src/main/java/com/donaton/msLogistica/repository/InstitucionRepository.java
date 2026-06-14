package com.donaton.msLogistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donaton.msLogistica.model.Institucion;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, Long> {

}
