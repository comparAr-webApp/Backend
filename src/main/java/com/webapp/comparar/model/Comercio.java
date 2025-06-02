package com.webapp.comparar.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comercios")
@IdClass(Comercio.ComercioId.class)
public class Comercio {

    public static class ComercioId implements Serializable {
        private Long idComercio;
        private Long idBandera;

        // Constructores, getters, equals y hashCode
        public ComercioId() {
        }

        public ComercioId(Long idComercio, Long idBandera) {
            this.idComercio = idComercio;
            this.idBandera = idBandera;
        }

        // Getters y Setters
        public Long getIdComercio() {
            return idComercio;
        }

        public void setIdComercio(Long idComercio) {
            this.idComercio = idComercio;
        }

        public Long getIdBandera() {
            return idBandera;
        }

        public void setIdBandera(Long idBandera) {
            this.idBandera = idBandera;
        }

        // equals y hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ComercioId that = (ComercioId) o;

            if (!idComercio.equals(that.idComercio)) return false;
            return idBandera.equals(that.idBandera);
        }

        @Override
        public int hashCode() {
            int result = idComercio.hashCode();
            result = 31 * result + idBandera.hashCode();
            return result;
        }
    }

    @Id
    @Column(name = "id_comercio")
    private Long idComercio;

    @Id
    @Column(name = "id_bandera")
    private Long idBandera;

    @Column(name = "comercio_bandera_nombre", nullable = false, length = 100)
    private String comercioBanderaNombre;

    // Constructores
    public Comercio() {
    }

    public Comercio(Long idComercio, Long idBandera, String comercioBanderaNombre) {
        this.idComercio = idComercio;
        this.idBandera = idBandera;
        this.comercioBanderaNombre = comercioBanderaNombre;
    }

    // Getters y Setters
    public Long getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Long idComercio) {
        this.idComercio = idComercio;
    }

    public Long getIdBandera() {
        return idBandera;
    }

    public void setIdBandera(Long idBandera) {
        this.idBandera = idBandera;
    }

    public String getComercioBanderaNombre() {
        return comercioBanderaNombre;
    }

    public void setComercioBanderaNombre(String comercioBanderaNombre) {
        this.comercioBanderaNombre = comercioBanderaNombre;
    }

    // toString
    @Override
    public String toString() {
        return "Comercio{" +
                "idComercio=" + idComercio +
                ", idBandera=" + idBandera +
                ", comercioBanderaNombre='" + comercioBanderaNombre + '\'' +
                '}';
    }
}