package com.Prendas.TiendaDeRopa.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Empresa")
public class Empresa {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_empresa", unique = true, length = 12)
   private long id_empresa;
   @Column(name = "nombre", nullable = false, length = 50)
   private String nombre;
   @Column(name = "documento", unique = true, nullable = false, length = 15)
   private String documento;
    @Column(name = "telefono", nullable = true, length = 15)
    private String telefono;
    @Column(name = "direccion", nullable = true, length = 50)
    private String direccion;

    @Column(name = "createdAt", nullable = true)
    private LocalDate createdAt;

    @Column(name = "updatedAt", nullable = true)
    private LocalDate updatedAt;

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Empresa() {
    }

    public Empresa(long id_empresa, String nombre, String documento, String telefono, String direccion, LocalDate createdAt, LocalDate updatedAt) {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
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
