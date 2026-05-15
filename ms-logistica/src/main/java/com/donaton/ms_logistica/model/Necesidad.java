package com.donaton.ms_logistica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "necesidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Necesidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private Institucion institucion;
    private Long categoriaId;
    private double cantidadRequerida;
    private LocalDateTime fechaSolicitud;
    private double cantidadCubierta;
    private String estado;
}

