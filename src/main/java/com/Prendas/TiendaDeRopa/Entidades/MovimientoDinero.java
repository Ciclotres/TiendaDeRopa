package com.Prendas.TiendaDeRopa.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="MovimientoDinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento", unique = true, length = 12)
    private long id_movimiento;
    @Column(name = "monto", nullable = false, length = 50)
    private float monto;
   @ManyToOne
   @JoinColumn(name = "id_empleado")
    private Empleado empleado;
   @Column(name = "concepto", nullable = false, length = 50)
   private String concepto;
   @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    @Column(name = "createdAt", nullable = true)
    private LocalDate createdAt;

    @Column(name = "updatedAt", nullable = true)
    private LocalDate updatedAt;

    public MovimientoDinero() {
    }

    public MovimientoDinero(long id_movimiento, float monto, Empleado empleado, String concepto, Empresa empresa, LocalDate createdAt, LocalDate updatedAt) {
        this.id_movimiento = id_movimiento;
        this.monto = monto;
        this.empleado = empleado;
        this.concepto = concepto;
        this.empresa = empresa;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(long id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        return "MovimientoDinero{" +
                "id_movimiento=" + id_movimiento +
                ", monto=" + monto +
                ", empleado=" + empleado +
                ", concepto='" + concepto + '\'' +
                ", empresa=" + empresa +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
