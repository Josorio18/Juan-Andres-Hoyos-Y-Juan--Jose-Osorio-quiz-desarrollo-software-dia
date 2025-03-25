package demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public class MotocicletaRepository {

    // Simulamos una base de datos con un Map
    private final Map<String, Motocicleta> baseDeDatos = new HashMap<>();

    // Guardar una motocicleta
    public Motocicleta save(Motocicleta motocicleta) {
        baseDeDatos.put(motocicleta.getId(), motocicleta);
        return motocicleta;
    }

    // Obtener todas las motocicletas
    public List<Motocicleta> findAll() {
        return new ArrayList<>(baseDeDatos.values());
    }

    // Buscar una motocicleta por ID
    public Optional<Motocicleta> findById(String id) {
        return Optional.ofNullable(baseDeDatos.get(id));
    }

    // Eliminar una motocicleta por ID
    public void deleteById(String id) {
        baseDeDatos.remove(id);
    }

    // Buscar una motocicleta por placa
    public Optional<Motocicleta> findByPlaca(String placa) {
        return baseDeDatos.values().stream()
                .filter(motocicleta -> motocicleta.getPlacaMotocicleta().equals(placa))
                .findFirst();
    }

    // Obtener motocicletas por cilindraje
    public List<Motocicleta> findByCilindraje(int cilindraje) {
        List<Motocicleta> resultado = new ArrayList<>();
        for (Motocicleta motocicleta : baseDeDatos.values()) {
            if (motocicleta.getCilindrajeMotocicleta() == cilindraje) {
                resultado.add(motocicleta);
            }
        }
        return resultado;
    }
}