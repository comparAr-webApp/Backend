package com.webapp.comparar.controller;

import com.webapp.comparar.model.Sucursal;
import com.webapp.comparar.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    // Obtener todas las sucursales
    @GetMapping
    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    // Crear una nueva sucursal
    @PostMapping
    public Sucursal createSucursal(@RequestBody Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    // Obtener una sucursal por ID compuesto
    @GetMapping("/{idComercio}/{idBandera}/{idSucursal}")
    public ResponseEntity<Sucursal> getSucursalById(
            @PathVariable Long idComercio,
            @PathVariable Long idBandera,
            @PathVariable Long idSucursal) {

        Sucursal.SucursalId id = new Sucursal.SucursalId(idComercio, idBandera, idSucursal);
        return sucursalRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar una sucursal
    @PutMapping("/{idComercio}/{idBandera}/{idSucursal}")
    public ResponseEntity<Sucursal> updateSucursal(
            @PathVariable Long idComercio,
            @PathVariable Long idBandera,
            @PathVariable Long idSucursal,
            @RequestBody Sucursal sucursalDetails) {

        Sucursal.SucursalId id = new Sucursal.SucursalId(idComercio, idBandera, idSucursal);
        return sucursalRepository.findById(id)
                .map(sucursal -> {
                    sucursal.setBarrio(sucursalDetails.getBarrio());
                    sucursal.setSucursalesNombre(sucursalDetails.getSucursalesNombre());
                    Sucursal updatedSucursal = sucursalRepository.save(sucursal);
                    return ResponseEntity.ok(updatedSucursal);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una sucursal
    @DeleteMapping("/{idComercio}/{idBandera}/{idSucursal}")
    public ResponseEntity<Void> deleteSucursal(
            @PathVariable Long idComercio,
            @PathVariable Long idBandera,
            @PathVariable Long idSucursal) {

        Sucursal.SucursalId id = new Sucursal.SucursalId(idComercio, idBandera, idSucursal);
        if (!sucursalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        sucursalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Método adicional para buscar sucursales por barrio
    @GetMapping("/por-barrio/{idBarrio}")
    public List<Sucursal> getSucursalesByBarrio(@PathVariable Long idBarrio) {
        return sucursalRepository.findByBarrioIdBarrios(idBarrio);
    }
}