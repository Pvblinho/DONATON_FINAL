package com.donaton.msDonaciones.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DonacionResponseDTO {
    
    private Long idDonacion;
    private Double cantidad;
    private LocalDateTime fechaRecepcion;
    private String nombreDonante;
    private String nombreCategoria;
    private Long centroAcopioId;
}