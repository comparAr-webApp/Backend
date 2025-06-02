package com.webapp.comparar.model;

import jakarta.persistence.*;


@Entity
@Table(name = "barrios")
public class Barrio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barrios")
    private Long idBarrios;

    @Column(name = "barrios_nombre", nullable = false, length = 100)
    private String barriosNombre;

    // Constructores
    public Barrio() {
    }

    public Barrio(String barriosNombre) {
        this.barriosNombre = barriosNombre;
    }

    // Getters y Setters
    public Long getIdBarrios() {
        return idBarrios;
    }

    public void setIdBarrios(Long idBarrios) {
        this.idBarrios = idBarrios;
    }

    public String getBarriosNombre() {
        return barriosNombre;
    }

    public void setBarriosNombre(String barriosNombre) {
        this.barriosNombre = barriosNombre;
    }

    // toString
    @Override
    public String toString() {
        return "Barrio{" +
                "idBarrios=" + idBarrios +
                ", barriosNombre='" + barriosNombre + '\'' +
                '}';
    }
}