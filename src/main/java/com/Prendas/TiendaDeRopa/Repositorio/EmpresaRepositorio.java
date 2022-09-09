package com.Prendas.TiendaDeRopa.Repositorio;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {
}
