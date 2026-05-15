package com.donaton.ms_donaciones.model;

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
@Table(name = "donacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donacion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Usuario origen;
    private Long centroAcopioId;
    private LocalDateTime fechaRecepcion;
}

