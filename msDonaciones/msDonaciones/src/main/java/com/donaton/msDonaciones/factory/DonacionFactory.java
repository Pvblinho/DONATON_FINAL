package com.donaton.msDonaciones.factory;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.donaton.msDonaciones.dto.DonacionRequestDTO;
import com.donaton.msDonaciones.model.Categoria;
import com.donaton.msDonaciones.model.Donacion;
import com.donaton.msDonaciones.model.Usuario;

@Component
public class DonacionFactory {

    public Donacion crearNuevaDonacion(DonacionRequestDTO dto, Usuario usuario, Categoria categoria) {
        Donacion nueva = new Donacion();
        
        nueva.setCantidad(dto.getCantidad().intValue());
        nueva.setCentroAcopioId(dto.getCentroAcopioId());
        
        nueva.setOrigen(usuario);
        nueva.setCategoria(categoria);
        
        nueva.setFechaRecepcion(LocalDateTime.now());
        
        return nueva;
    }
}