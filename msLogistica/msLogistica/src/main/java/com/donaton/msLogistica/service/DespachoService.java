package com.donaton.msLogistica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.donaton.msLogistica.model.Despacho;
import com.donaton.msLogistica.repository.DespachoRepository;

@Service
public class DespachoService {

    private final DespachoRepository despachoRepository;

    public DespachoService(DespachoRepository despachoRepository) {
        this.despachoRepository = despachoRepository;
    }

    public List<Despacho> getDespachos() {
        return despachoRepository.findAll();
    }

    public Despacho getDespachoById(Long id) {
        return despachoRepository.findById(id).orElse(null);
    }

    public Despacho saveDespacho(Despacho despacho) {
        return despachoRepository.save(despacho);
    }

    public Despacho updateDespacho(Long id, Despacho despacho) {
        if (despachoRepository.existsById(id)) {
            despacho.setId(id);
            return despachoRepository.save(despacho);
        }
        return null;
    }

    public String deleteDespacho(Long id) {
        if (despachoRepository.existsById(id)) {
            despachoRepository.deleteById(id);
            return "Despacho eliminado";
        }
        return "Despacho no encontrado";
    }
}
