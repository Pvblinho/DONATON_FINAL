package com.donaton.msLogistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msLogistica.model.Necesidad;
import com.donaton.msLogistica.repository.NecesidadRepository;

@Service
public class NecesidadService {

    private final NecesidadRepository necesidadRepository;

    public NecesidadService(NecesidadRepository necesidadRepository) {
        this.necesidadRepository = necesidadRepository;
    }

    public List<Necesidad> getNecesidades() {
        return necesidadRepository.findAll();
    }

    public Necesidad getNecesidadById(Long id) {
        return necesidadRepository.findById(id).orElse(null);
    }

    public Necesidad saveNecesidad(Necesidad necesidad) {
        return necesidadRepository.save(necesidad);
    }

    public Necesidad updateNecesidad(Long id, Necesidad necesidad) {
        if (necesidadRepository.existsById(id)) {
            necesidad.setId(id);
            return necesidadRepository.save(necesidad);
        }
        return null;
    }

    public String deleteNecesidad(Long id) {
        if (necesidadRepository.existsById(id)) {
            necesidadRepository.deleteById(id);
            return "Necesidad eliminada";
        }
        return "Necesidad no encontrada";
    }
}
