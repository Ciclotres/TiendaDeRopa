package com.themasters.demo;

public class movimientoDinero {
    private long id;
    private float monto;
    private empleado empleado;

    public movimientoDinero(long id, float monto, com.themasters.demo.empleado empleado) {
        this.id = id;
        this.monto = monto;
        this.empleado = empleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public com.themasters.demo.empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(com.themasters.demo.empleado empleado) {
        this.empleado = empleado;
    }
}
