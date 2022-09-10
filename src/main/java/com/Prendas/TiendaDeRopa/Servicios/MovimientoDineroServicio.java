package com.Prendas.TiendaDeRopa.Servicios;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Entidades.MovimientoDinero;
import com.Prendas.TiendaDeRopa.Repositorio.MovimientoDineroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class MovimientoDineroServicio {

   private MovimientoDineroRepositorio repositorio;

    public MovimientoDineroServicio(MovimientoDineroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<MovimientoDinero> listarMovimiento(){
        return (ArrayList<MovimientoDinero>) repositorio.findAll();
    }
    //no sabemos como buscar con tipo long
    public Optional<MovimientoDinero> buscarMovimiento(long id_movimiento){
        return repositorio.findById(id_movimiento);
    }
    public String crearMovimiento(MovimientoDinero movimientoDinero){
        if(!buscarMovimiento(movimientoDinero.getId_movimiento()).isPresent()) {
            repositorio.save(movimientoDinero);
            return "Movimiento registrado exitosamente";
        }
        else {
            return "El movimiento ya existe.";
        }
    }
    @PatchMapping("/{id_movimiento}")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id_movimiento") Long id_movimiento, @RequestBody MovimientoDinero movimientoDinero) {
        Optional<MovimientoDinero> dbdata = repositorio.findById(id_movimiento);
        if (dbdata.isPresent()) {
            MovimientoDinero movimientos = dbdata.get();
            movimientos.setMonto(movimientoDinero.getMonto());
            movimientos.setConcepto(movimientoDinero.getConcepto());
            movimientos.setEmpleado(movimientoDinero.getEmpleado());
            movimientos.setEmpresa(movimientoDinero.getEmpresa());
            movimientos.setCreatedAt(movimientoDinero.getCreatedAt());
            movimientos.setUpdatedAt(movimientoDinero.getUpdatedAt());


            this.repositorio.save(movimientos);
            return movimientos;
        }
        return null;
    }
    public String eliminarMovimiento(Long id_movimiento){
        if(buscarMovimiento(id_movimiento).isPresent()){
            repositorio.deleteAllById(Collections.singleton(id_movimiento));
            return "Movimiento Eliminado";
        }
        else {
            return "El movimiento a eliminar no existe";
        }
    }
}
