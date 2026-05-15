package com.donaton.ms_logistica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "institucion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institucion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nombre;
    private String tipo;
    private String nombreContacto;
    private String Direccion;
    private String Comuna;
}
