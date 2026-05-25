package com.donaton.msLogistica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Necesidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Esta variable guarda el ID del recurso (Agua, Ropa) que vive en ms-donaciones
    private Long categoriaId; 

    private Double cantidadRequerida;
    private Double cantidadCubierta;
    private String estado; // Ej: "PENDIENTE", "EN_PROGRESO", "CUBIERTA"

    // Relación directa: Muchas necesidades pueden pertenecer a una misma Institución
    @ManyToOne
    @JoinColumn(name = "institucion_id")
    private Institucion institucion;
}