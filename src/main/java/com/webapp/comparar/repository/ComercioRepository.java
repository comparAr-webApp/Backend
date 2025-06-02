package com.webapp.comparar.repository;

import com.webapp.comparar.model.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Comercio.ComercioId> {
    // Puedes agregar métodos personalizados aquí si los necesitas
    // Ejemplo: Buscar por nombre de bandera
    // List<Comercio> findByComercioBanderaNombreContaining(String nombre);
}