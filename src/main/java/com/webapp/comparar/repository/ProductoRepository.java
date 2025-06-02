package com.webapp.comparar.repository;

import com.webapp.comparar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductoRepository extends
        JpaRepository<Producto, Long>,
        JpaSpecificationExecutor<Producto>{
    List<Producto> findByDescripcionContainingIgnoreCase(String termino, org.springframework.data.domain.Pageable pageable);
}

