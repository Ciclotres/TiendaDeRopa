package com.themasters.demo;

public class empleado extends empresa{
    public long id;
    public String correo;

    public empleado(long id, String nombre, String documento, String telefono, String direccion, long id1, String correo) {
        super(id, nombre, documento, telefono, direccion);
        this.id = id1;
        this.correo = correo;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "empleado{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
