package com.webapp.comparar.controller;

import com.webapp.comparar.model.Barrio;
import com.webapp.comparar.repository.BarrioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/barrios")
public class BarrioController {

    @Autowired
    private BarrioRepository barrioRepository;

    // Obtener todos los barrios
    @GetMapping
    public List<Barrio> getAllBarrios() {
        return barrioRepository.findAll();
    }

    // Crear un nuevo barrio
    @PostMapping
    public Barrio createBarrio(@RequestBody Barrio barrio) {
        return barrioRepository.save(barrio);
    }

    // Obtener un barrio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Barrio> getBarrioById(@PathVariable Long id) {
        Optional<Barrio> barrio = barrioRepository.findById(id);
        return barrio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un barrio
    @PutMapping("/{id}")
    public ResponseEntity<Barrio> updateBarrio(@PathVariable Long id, @RequestBody Barrio barrioDetails) {
        Optional<Barrio> optionalBarrio = barrioRepository.findById(id);
        if (optionalBarrio.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Barrio barrio = optionalBarrio.get();
        barrio.setBarriosNombre(barrioDetails.getBarriosNombre());

        Barrio updatedBarrio = barrioRepository.save(barrio);
        return ResponseEntity.ok(updatedBarrio);
    }

    // Eliminar un barrio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarrio(@PathVariable Long id) {
        if (!barrioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        barrioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}