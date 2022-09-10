package com.Prendas.TiendaDeRopa.Repositorio;

import com.Prendas.TiendaDeRopa.Entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepositorio extends JpaRepository<MovimientoDinero, Long> {
}
