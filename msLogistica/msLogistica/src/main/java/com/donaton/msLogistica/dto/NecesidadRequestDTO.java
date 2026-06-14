package com.donaton.msLogistica.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NecesidadRequestDTO {

    // Variable clave para optimizar en el Service
    @NotNull(message = "Debe indicar qué institución pide la ayuda")
    private Long institucionId;

    @NotNull(message = "Debe indicar el ID del recurso que necesita (Agua, Ropa, etc.)")
    private Long categoriaId;

    @NotNull(message = "Debe indicar la cantidad")
    @Min(value = 1, message = "Debe solicitar al menos 1 unidad")
    private Double cantidadRequerida;
}