package com.webapp.comparar.controller;

import com.webapp.comparar.model.Comercio;
import com.webapp.comparar.repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comercios")
public class ComercioController {

    @Autowired
    private ComercioRepository comercioRepository;

    // Obtener todos los comercios
    @GetMapping
    public List<Comercio> getAllComercios() {
        return comercioRepository.findAll();
    }

    // Crear un nuevo comercio
    @PostMapping
    public Comercio createComercio(@RequestBody Comercio comercio) {
        return comercioRepository.save(comercio);
    }

    // Obtener un comercio por ID compuesto
    @GetMapping("/{idComercio}/{idBandera}")
    public ResponseEntity<Comercio> getComercioById(
            @PathVariable Long idComercio,
            @PathVariable Long idBandera) {

        Comercio.ComercioId id = new Comercio.ComercioId(idComercio, idBandera);
        return comercioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un comercio
    @PutMapping("/{idComercio}/{idBandera}")
    public ResponseEntity<Comercio> updateComercio(
            @PathVariable Long idComercio,
            @PathVariable Long idBandera,
            @RequestBody Comercio comercioDetails) {

        Comercio.ComercioId id = new Comercio.ComercioId(idComercio, idBandera);
        return comercioRepository.findById(id)
                .map(comercio -> {
                    comercio.setComercioBanderaNombre(comercioDetails.getComercioBanderaNombre());
                    Comercio updatedComercio = comercioRepository.save(comercio);
                    return ResponseEntity.ok(updatedComercio);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un comercio
    @DeleteMapping("/{idComercio}/{idBandera}")
    public ResponseEntity<Void> deleteComercio(
            @PathVariable Long idComercio,
            @PathVariable Long idBandera) {

        Comercio.ComercioId id = new Comercio.ComercioId(idComercio, idBandera);
        if (!comercioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        comercioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}