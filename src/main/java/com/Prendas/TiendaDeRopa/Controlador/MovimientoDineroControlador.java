package com.Prendas.TiendaDeRopa.Controlador;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Entidades.MovimientoDinero;
import com.Prendas.TiendaDeRopa.Servicios.MovimientoDineroServicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class MovimientoDineroControlador {
    private MovimientoDineroServicio servicio;

    public MovimientoDineroControlador(MovimientoDineroServicio servicio) {
        this.servicio = servicio;
    }
    @GetMapping("/ListarMovimiento")
    public ArrayList<MovimientoDinero> listar(){
        return servicio.listarMovimiento();
    }

    @GetMapping("/BuscarMovimiento/{id_movimiento}")
    public Optional<MovimientoDinero> buscarMovimiento(@PathVariable("id_movimiento") Long id_movimiento){
        return servicio.buscarMovimiento(id_movimiento);
    }
    @PostMapping("/CrearMovimiento")
    public String crearMovimiento(@RequestBody MovimientoDinero movimientoDinero){
        return servicio.crearMovimiento(movimientoDinero);
    }
    //MIRAR LO DE ACTUALIZAR CUALQUIER CAMPO  PQ HASTA AHORA SI BUSCA EL ID PERO QUE CAMBIA?
    @PatchMapping("/ActualizarMovimiento/{id_movimiento}")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id_movimiento") Long id_movimiento, @RequestBody MovimientoDinero movimientoDinero){
        return servicio.actualizarMovimiento(id_movimiento,movimientoDinero);
    }
    @DeleteMapping("/EliminarMovimiento/{id_movimiento}")
    public String eliminarMovimiento(@PathVariable("id_movimiento") Long id_movimiento){
        return servicio.eliminarMovimiento(id_movimiento);
    }
}
