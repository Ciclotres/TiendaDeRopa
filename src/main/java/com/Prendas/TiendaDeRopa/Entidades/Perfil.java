package com.Prendas.TiendaDeRopa.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil", unique = true, length = 12)
    private String id_perfil;
    @Column(name = "image", nullable = true, length = 50)
    private String image;
    @Column(name = "telefono", nullable = true, length = 12)
    private String telefono;

    @Column(name = "createdAt", nullable = true)
    private LocalDate createdAt;
    @Column(name = "updatedAt", nullable = true)
    private LocalDate updatedAt;

    //pendiente el campo user
    public Perfil() {
    }

    public Perfil(String id_perfil, String image, String telefono, LocalDate createdAt, LocalDate updatedAt) {
        this.id_perfil = id_perfil;
        this.image = image;
        this.telefono = telefono;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(String id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id_perfil='" + id_perfil + '\'' +
                ", image='" + image + '\'' +
                ", telefono='" + telefono + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
