package com.Prendas.TiendaDeRopa.Entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado", unique = true, length = 12)
    private long id_empleado;
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    @Column(name = "rol", nullable = false, length = 5)
    private Rol rol; //preguntar al profe
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa; //atributo empresa es de tipo empresa

    @OneToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @Column(name = "createdAt", nullable = true)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = true)
    private Date updatedAt;

    public Empleado() {
    }

    public Empleado(long id_empleado, String correo, Rol rol, Empresa empresa, Perfil perfil, Date createdAt, Date updatedAt) {
        this.id_empleado = id_empleado;
        this.correo = correo;
        this.rol = rol;
        this.empresa = empresa;
        this.perfil = perfil;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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
        return "Empleado{" +
                "id_empleado=" + id_empleado +
                ", correo='" + correo + '\'' +
                ", rol=" + rol +
                ", empresa=" + empresa +
                ", perfil=" + perfil +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
