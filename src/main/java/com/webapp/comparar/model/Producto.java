package com.webapp.comparar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos") // Nombre de la tabla en la base de datos
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto") // Si el nombre en la BD es diferente
    private Long idProducto;

    @Column(name = "productos_descripcion", nullable = false, length = 255)
    private String descripcion;

    // Constructor vacío (requerido por JPA)
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}