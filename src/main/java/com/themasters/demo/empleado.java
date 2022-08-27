package com.themasters.demo;

import java.util.List;

public class empleado {
    private long id;
    private String correo;
    private String rol;
    private empresa empresa; //atributo empresa es de tipo empresa
    private List<movimientoDinero> movimientosD; // cuales fueron los movimientos segun empleado

    public empleado(long id, String correo, String rol, com.themasters.demo.empresa empresa, List<movimientoDinero> movimientosD) {
        this.id = id;
        this.correo = correo;
        this.rol = rol;
        this.empresa = empresa;
        this.movimientosD = movimientosD;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public com.themasters.demo.empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(com.themasters.demo.empresa empresa) {
        this.empresa = empresa;
    }

    public List<movimientoDinero> getMovimientosD() {
        return movimientosD;
    }

    public void setMovimientosD(List<movimientoDinero> movimientosD) {
        this.movimientosD = movimientosD;
    }
}
