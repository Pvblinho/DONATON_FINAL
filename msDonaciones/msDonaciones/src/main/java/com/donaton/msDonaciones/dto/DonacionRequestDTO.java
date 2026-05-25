package com.donaton.msDonaciones.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DonacionRequestDTO {

    @NotNull(message = "Debe indicar la cantidad donada")
    @Min(value = 1, message = "La donación mínima es 1")
    private Double cantidad;

    @NotNull(message = "El ID del centro de acopio es obligatorio")
    private Long centroAcopioId;

    @NotNull(message = "Debe indicar el donante")
    private Long usuarioId;

    @NotNull(message = "Debe indicar la categoría (ropa, agua, etc.)")
    private Long categoriaId;
}