package com.Prendas.TiendaDeRopa.Controlador;

import com.Prendas.TiendaDeRopa.Entidades.Empleado;
import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Servicios.EmpleadoServicio;
import com.Prendas.TiendaDeRopa.Servicios.EmpresaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class EmpleadoControlador {

        private EmpleadoServicio servicio;


        public EmpleadoControlador(EmpleadoServicio servicio) {
                this.servicio = servicio;
        }
        @GetMapping("/ListarEmpleado")
        public ArrayList<Empleado> listar(){
                return servicio.listarEmpleado();
        }

        @GetMapping("/BuscarEmpleado/{id_empreado}")
        public Optional<Empleado> buscarEmpleado(@PathVariable("id_empleado") Long id_empleado){
                return servicio.buscarEmpleado(id_empleado);
        }
        @PostMapping("/CrearEmpleado")
        public String crearEmpleado(@RequestBody Empleado empleado){

                return servicio.crearEmpleado(empleado);
        }
        //MIRAR LO DE ACTUALIZAR CUALQUIER CAMPO  PQ HASTA AHORA SI BUSCA EL ID PERO QUE CAMBIA?
        @PatchMapping("/ActualizarEmpleado/{id_empleado}")
        public String actualizarEmpleado(@PathVariable("id_empleado") Long id_empleado){
                return servicio.actualizarEmpleado(id_empleado);
        }
        @DeleteMapping("/EliminarEmpleado/{id_empleado}")
        public String eliminarEmpleado(@PathVariable("id_empleado") Long id_empleado){
                return servicio.eliminarEmpleado(id_empleado);
        }

}
