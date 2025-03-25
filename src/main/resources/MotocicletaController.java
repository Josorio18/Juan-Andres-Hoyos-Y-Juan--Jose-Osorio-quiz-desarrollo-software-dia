package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/motocicletas")
public class MotocicletaController {

    private List<Motocicleta> motocicletas = new ArrayList<>();

    @GetMapping
    public List<Motocicleta> obtenerTodasLasMotocicletas() {
        return motocicletas;
    }

    @PostMapping
    public Motocicleta crearMotocicleta(@RequestBody Motocicleta motocicleta) {
        motocicleta.setId(UUID.randomUUID().toString());
        motocicletas.add(motocicleta);
        return motocicleta;
    }

    @PutMapping("/{id}")
    public Motocicleta actualizarMotocicleta(@PathVariable String id, @RequestBody Motocicleta motocicletaActualizada) {
        for (Motocicleta m : motocicletas) {
            if (m.getId().equals(id)) {
                m.setMarcaMotocicleta(motocicletaActualizada.getMarcaMotocicleta());
                m.setPlacaMotocicleta(motocicletaActualizada.getPlacaMotocicleta());
                m.setCilindrajeMotocicleta(motocicletaActualizada.getCilindrajeMotocicleta());
                m.setPrecioMotocicleta(motocicletaActualizada.getPrecioMotocicleta());
                m.setColorMotocicleta(motocicletaActualizada.getColorMotocicleta());
                return m;
            }
        }
        return null; // o lanzar una excepción
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMotocicleta(@PathVariable String id) {
        motocicletas.removeIf(m -> m.getId().equals(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/placa/{placa}")
    public Motocicleta buscarPorPlaca(@PathVariable String placa) {
        return motocicletas.stream()
                .filter(m -> m.getPlacaMotocicleta().equals(placa))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/cilindraje/{cilindraje}")
    public List<Motocicleta> obtenerPorCilindraje(@PathVariable int cilindraje) {
        return motocicletas.stream()
                .filter(m -> m.getCilindrajeMotocicleta() == cilindraje)
                .collect(Collectors.toList());
    }
}