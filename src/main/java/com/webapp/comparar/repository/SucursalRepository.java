package com.webapp.comparar.repository;

import com.webapp.comparar.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Sucursal.SucursalId> {
    // Métodos personalizados si son necesarios
    // Ejemplo: Buscar sucursales por nombre
    // List<Sucursal> findBySucursalesNombreContaining(String nombre);

    // Ejemplo: Buscar sucursales por barrio
     List<Sucursal> findByBarrioIdBarrios(Long idBarrio);
}