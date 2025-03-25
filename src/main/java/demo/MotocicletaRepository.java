package demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MotocicletaRepository {

    
    private final Map<String, Motocicleta> baseDeDatos = new HashMap<>();

    
    public MotocicletaRepository() {
        for (Motocicleta moto : Motocicleta.crearDatosIniciales()) {
            baseDeDatos.put(moto.getId(), moto);
        }
    }

    public Motocicleta save(Motocicleta motocicleta) {
        baseDeDatos.put(motocicleta.getId(), motocicleta);
        return motocicleta;
    }

   
    public List<Motocicleta> findAll() {
        return new ArrayList<>(baseDeDatos.values());
    }

    
    public Optional<Motocicleta> findById(String id) {
        return Optional.ofNullable(baseDeDatos.get(id));
    }

    
    public void deleteById(String id) {
        baseDeDatos.remove(id);
    }

   
    public Optional<Motocicleta> findByPlaca(String placa) {
        return baseDeDatos.values().stream()
                .filter(motocicleta -> motocicleta.getPlacaMotocicleta().equals(placa))
                .findFirst();
    }

    
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
