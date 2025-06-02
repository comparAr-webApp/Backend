package com.webapp.comparar.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sucursales")
@IdClass(Sucursal.SucursalId.class)
public class Sucursal {

    public static class SucursalId implements Serializable {
        private Long idComercio;
        private Long idBandera;
        private Long idSucursal;

        // Constructores
        public SucursalId() {
        }

        public SucursalId(Long idComercio, Long idBandera, Long idSucursal) {
            this.idComercio = idComercio;
            this.idBandera = idBandera;
            this.idSucursal = idSucursal;
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

        public Long getIdSucursal() {
            return idSucursal;
        }

        public void setIdSucursal(Long idSucursal) {
            this.idSucursal = idSucursal;
        }

        // equals y hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SucursalId that = (SucursalId) o;

            if (!idComercio.equals(that.idComercio)) return false;
            if (!idBandera.equals(that.idBandera)) return false;
            return idSucursal.equals(that.idSucursal);
        }

        @Override
        public int hashCode() {
            int result = idComercio.hashCode();
            result = 31 * result + idBandera.hashCode();
            result = 31 * result + idSucursal.hashCode();
            return result;
        }
    }

    @Id
    @Column(name = "id_comercio")
    private Long idComercio;

    @Id
    @Column(name = "id_bandera")
    private Long idBandera;

    @Id
    @Column(name = "id_sucursal")
    private Long idSucursal;

    @ManyToOne
    @JoinColumn(name = "id_barrios", referencedColumnName = "id_barrios")
    private Barrio barrio;

    @Column(name = "sucursales_nombre", nullable = false, length = 100)
    private String sucursalesNombre;

    // Relación con Comercio (clave compuesta)
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio", insertable = false, updatable = false),
            @JoinColumn(name = "id_bandera", referencedColumnName = "id_bandera", insertable = false, updatable = false)
    })
    private Comercio comercio;

    // Constructores
    public Sucursal() {
    }

    public Sucursal(Long idComercio, Long idBandera, Long idSucursal, Barrio barrio, String sucursalesNombre) {
        this.idComercio = idComercio;
        this.idBandera = idBandera;
        this.idSucursal = idSucursal;
        this.barrio = barrio;
        this.sucursalesNombre = sucursalesNombre;
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

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public String getSucursalesNombre() {
        return sucursalesNombre;
    }

    public void setSucursalesNombre(String sucursalesNombre) {
        this.sucursalesNombre = sucursalesNombre;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    // toString
    @Override
    public String toString() {
        return "Sucursal{" +
                "idComercio=" + idComercio +
                ", idBandera=" + idBandera +
                ", idSucursal=" + idSucursal +
                ", barrio=" + (barrio != null ? barrio.getIdBarrios() : null) +
                ", sucursalesNombre='" + sucursalesNombre + '\'' +
                '}';
    }
}