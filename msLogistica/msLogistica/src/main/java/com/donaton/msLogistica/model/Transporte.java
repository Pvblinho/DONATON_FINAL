package com.donaton.msLogistica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transporte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transporte {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String patente;
    private String tipoVehiculo;
    private Double capacidad;
    private Boolean disponible;
}
