package com.donaton.msLogistica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Despacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaSalida;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "centro_origen_id")
    private CentroDeAcopio centroOrigen;
    @ManyToOne
    @JoinColumn(name = "transporte_id")
    private Transporte transporte;
    @ManyToOne
    @JoinColumn(name = "necesidad_destino_id")
    private Necesidad necesidad;
}