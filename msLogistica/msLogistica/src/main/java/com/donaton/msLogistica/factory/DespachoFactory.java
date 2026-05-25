package com.donaton.msLogistica.factory;

import com.donaton.msLogistica.dto.DespachoRequestDTO;
import com.donaton.msLogistica.model.CentroDeAcopio;
import com.donaton.msLogistica.model.Despacho;
import com.donaton.msLogistica.model.Necesidad;
import com.donaton.msLogistica.model.Transporte;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DespachoFactory {

    // El Service te pasará las entidades que buscó en la BD y tú armas el paquete final
    public Despacho crearNuevoDespacho(CentroDeAcopio origen, Transporte vehiculo, Necesidad necesidad) {
        Despacho nuevoDespacho = new Despacho();
        
        nuevoDespacho.setCentroOrigen(origen);
        nuevoDespacho.setTransporte(vehiculo);
        nuevoDespacho.setNecesidad(necesidad);
        
        // Reglas de negocio automáticas: 
        // El frontend no manda la fecha ni el estado, el sistema lo asigna solo.
        nuevoDespacho.setFechaSalida(LocalDateTime.now());
        nuevoDespacho.setEstado("EN_PREPARACION");
        
        return nuevoDespacho;
    }
}