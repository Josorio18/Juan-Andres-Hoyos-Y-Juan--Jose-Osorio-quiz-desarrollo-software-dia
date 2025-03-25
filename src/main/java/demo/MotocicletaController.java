package demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@RestController
@RequestMapping("/api/motocicletas")
@Validated
public class MotocicletaController {
    
    private final MotocicletaService motocicletaService;

    public MotocicletaController(MotocicletaService motocicletaService) {
        this.motocicletaService = motocicletaService;
    }

    @GetMapping
    public ResponseEntity<List<Motocicleta>> obtenerTodas() {
        return ResponseEntity.ok(motocicletaService.obtenerTodas());
    }

    @PostMapping
    public ResponseEntity<Motocicleta> crear(@Valid @RequestBody Motocicleta moto) {
        return ResponseEntity.ok(motocicletaService.crear(moto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motocicleta> actualizar(@PathVariable String id, @Valid @RequestBody Motocicleta moto) {
        return ResponseEntity.ok(motocicletaService.actualizar(id, moto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        motocicletaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Motocicleta> buscarPorPlaca(@PathVariable String placa) {
        return ResponseEntity.ok(motocicletaService.buscarPorPlaca(placa));
    }

    @GetMapping("/cilindraje/{cilindraje}")
    public ResponseEntity<List<Motocicleta>> filtrarPorCilindraje(@PathVariable int cilindraje) {
        return ResponseEntity.ok(motocicletaService.filtrarPorCilindraje(cilindraje));
    }

    @GetMapping("/precio/{precioMax}")
    public ResponseEntity<List<Motocicleta>> filtrarPorPrecio(@PathVariable double precioMax) {
        return ResponseEntity.ok(motocicletaService.filtrarPorPrecio(precioMax));
    }
}
