package com.Prendas.TiendaDeRopa.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Empresa")
public class Empresa {
   @Id
   @Column(name = "id_empresa", unique = true, length = 12)
   private long id_empresa;
   @Column(name = "nombre", nullable = false, length = 50)
   private String nombre;
   @Column(name = "documento", unique = true, nullable = false, length = 15)
   private String documento;
    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;

    public Empresa() {
    }

    public Empresa(long id_empresa, String nombre, String documento, String telefono, String direccion, Date createdAt, Date updatedAt) {
        this.id_empresa = id_empresa;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id_empresa=" + id_empresa +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
