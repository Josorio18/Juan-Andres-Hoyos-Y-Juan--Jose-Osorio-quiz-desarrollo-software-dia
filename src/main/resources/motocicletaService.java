package com.ejemplo.motocicleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotocicletaService {
    @Autowired
    private MotocicletaRepository repository;

    public List<Motocicleta> obtenerTodas() {
        return repository.findAll();
    }

    public Motocicleta obtenerPorPlaca(String placa) {
        return repository.findByPlaca(placa);
    }

    public Motocicleta crear(Motocicleta motocicleta) {
        return repository.save(motocicleta);
    }

    public Motocicleta actualizar(Motocicleta motocicleta) {
        return repository.save(motocicleta);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}