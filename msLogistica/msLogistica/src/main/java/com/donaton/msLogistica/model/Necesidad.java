package com.donaton.msLogistica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@Table(name = "necesidades")

public class Necesidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long categoriaId;
    private Double cantidadRequerida;
    private Double cantidadCubierta;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "institucion_id")
    private Institucion institucion;
}