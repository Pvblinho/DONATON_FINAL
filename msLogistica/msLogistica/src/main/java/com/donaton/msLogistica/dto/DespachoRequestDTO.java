package com.donaton.msLogistica.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DespachoRequestDTO {

    @NotNull(message = "Debe indicar el centro de acopio de origen")
    private Long centroOrigenId;

    @NotNull(message = "Debe indicar el vehículo asignado")
    private Long transporteId;

    @NotNull(message = "Debe indicar la necesidad que va a cubrir")
    private Long necesidadDestinoId;
}