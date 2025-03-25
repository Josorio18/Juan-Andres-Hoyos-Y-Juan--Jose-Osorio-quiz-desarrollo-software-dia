package demo;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MotocicletaService {

    private final MotocicletaRepository motocicletaRepository;

    public MotocicletaService(MotocicletaRepository motocicletaRepository) {
        this.motocicletaRepository = motocicletaRepository;
    }

    public List<Motocicleta> obtenerTodas() {
        return motocicletaRepository.findAll();
    }

    public Motocicleta crear(Motocicleta moto) {
        return motocicletaRepository.save(moto);
    }

    public Motocicleta actualizar(String id, Motocicleta moto) {
        return motocicletaRepository.findById(id)
                .map(existingMoto -> {
                    existingMoto.setMarcaMotocicleta(moto.getMarcaMotocicleta());
                    existingMoto.setPlacaMotocicleta(moto.getPlacaMotocicleta());
                    existingMoto.setCilindrajeMotocicleta(moto.getCilindrajeMotocicleta());
                    existingMoto.setPrecioMotocicleta(moto.getPrecioMotocicleta());
                    existingMoto.setColorMotocicleta(moto.getColorMotocicleta());
                    return motocicletaRepository.save(existingMoto);
                }).orElseThrow(() -> new RuntimeException("Motocicleta no encontrada"));
    }

    public void eliminar(String id) {
        motocicletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motocicleta no encontrada"));
        motocicletaRepository.deleteById(id);
    }

    public Motocicleta buscarPorPlaca(String placa) {
        return motocicletaRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Motocicleta con placa " + placa + " no encontrada"));
    }

    public List<Motocicleta> filtrarPorCilindraje(int cilindraje) {
        return motocicletaRepository.findAll().stream()
                .filter(moto -> moto.getCilindrajeMotocicleta() == cilindraje)
                .collect(Collectors.toList());
    }

    public List<Motocicleta> filtrarPorPrecio(double precioMax) {
        return motocicletaRepository.findAll().stream()
                .filter(moto -> moto.getPrecioMotocicleta() <= precioMax)
                .collect(Collectors.toList());
    }
}
