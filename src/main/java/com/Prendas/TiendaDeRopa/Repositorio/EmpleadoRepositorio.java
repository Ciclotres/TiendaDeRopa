package com.Prendas.TiendaDeRopa.Repositorio;

import com.Prendas.TiendaDeRopa.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
