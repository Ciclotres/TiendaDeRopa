package com.Prendas.TiendaDeRopa.Entidades;

import javax.persistence.*;
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
    private Date createdAt;
    @Column(name = "updatedAt", nullable = true)
    private Date updatedAt;

    //pendiente el campo user
    public Perfil() {
    }

    public Perfil(String id_perfil, String image, String telefono, Date createdAt, Date updatedAt) {
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
        return "Perfil{" +
                "id_perfil='" + id_perfil + '\'' +
                ", image='" + image + '\'' +
                ", telefono='" + telefono + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
