package com.donaton.msLogistica.factory;

import com.donaton.msLogistica.dto.NecesidadRequestDTO;
import com.donaton.msLogistica.model.Institucion;
import com.donaton.msLogistica.model.Necesidad;
import org.springframework.stereotype.Component;

@Component
public class NecesidadFactory {

    public Necesidad crearNuevaNecesidad(NecesidadRequestDTO dto, Institucion institucion) {
        Necesidad nuevaNecesidad = new Necesidad();
        
        // Asignación limpia de variables
        nuevaNecesidad.setInstitucion(institucion); 
        nuevaNecesidad.setCategoriaId(dto.getCategoriaId());
        nuevaNecesidad.setCantidadRequerida(dto.getCantidadRequerida());
        
        // Reglas de negocio iniciales:
        // Toda necesidad nace con 0 cosas cubiertas y en estado pendiente
        nuevaNecesidad.setCantidadCubierta(0.0);
        nuevaNecesidad.setEstado("PENDIENTE");
        
        return nuevaNecesidad;
    }
}