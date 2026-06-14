package com.donaton.msLogistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msLogistica.model.Institucion;
import com.donaton.msLogistica.repository.InstitucionRepository;

@Service
public class InstitucionService {

    private final InstitucionRepository institucionRepository;

    public InstitucionService(InstitucionRepository institucionRepository) {
        this.institucionRepository = institucionRepository;
    }

    public List<Institucion> getInstituciones() {
        return institucionRepository.findAll();
    }

    public Institucion getInstitucionById(Long id) {
        return institucionRepository.findById(id).orElse(null);
    }

    public Institucion saveInstitucion(Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    public Institucion updateInstitucion(Long id, Institucion institucion) {
        if (institucionRepository.existsById(id)) {
            institucion.setId(id);
            return institucionRepository.save(institucion);
        }
        return null;
    }

    public String deleteInstitucion(Long id) {
        if (institucionRepository.existsById(id)) {
            institucionRepository.deleteById(id);
            return "Institución eliminada";
        }
        return "Institución no encontrada";
    }
}
