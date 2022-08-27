package com.themasters.demo;

public class movimientoDinero extends empleado {
    public long ide;
    public float monto;


    public movimientoDinero(long id, String nombre, String documento, String telefono, String direccion, long id1, String correo, long ide, float monto) {
        super(id, nombre, documento, telefono, direccion, id1, correo);
        this.ide = ide;
        this.monto = monto;
    }

    public long getIde() {
        return ide;
    }

    public void setIde(long ide) {
        this.ide = ide;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "movimientoDinero{" +
                "ide=" + ide +
                ", monto=" + monto +
                ", id=" + id +
                ", correo='" + correo + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
