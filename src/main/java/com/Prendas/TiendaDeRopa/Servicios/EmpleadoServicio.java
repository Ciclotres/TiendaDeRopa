package com.Prendas.TiendaDeRopa.Servicios;


import com.Prendas.TiendaDeRopa.Entidades.Empleado;
import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Repositorio.EmpleadoRepositorio;
import com.Prendas.TiendaDeRopa.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class EmpleadoServicio {
    private EmpleadoRepositorio repositorio;

    public EmpleadoServicio(EmpleadoRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public ArrayList<Empleado> listarEmpleado(){
        return (ArrayList<Empleado>) repositorio.findAll();
    }
    //no sabemos como buscar con tipo long
    public Optional<Empleado> buscarEmpleado(long id_empleado){
        return repositorio.findById(id_empleado);
    }
    public String crearEmpleado(Empleado empleado){
        if(!buscarEmpleado(empleado.getId_empleado()).isPresent()) {
            repositorio.save(empleado);
            return "Empleado registrada exitosamente";
        }
        else {
            return "El emprleado ya existe.";
        }
    }
    public String actualizarEmpleado(Long id_empleado){
        if (buscarEmpleado(id_empleado).isPresent()){
            Empleado empleado=repositorio.findById(id_empleado).get();
            repositorio.save(empleado);
            return "Empleado Actualizado";
        }
        else {
            return "El Empleado a actualizar no existe";
        }
    }
    public String eliminarEmpleado(Long id_empleado){
        if(buscarEmpleado(id_empleado).isPresent()){
            repositorio.deleteAllById(Collections.singleton(id_empleado));
            return "Empleado eliminado";
        }
        else {
            return "El empleado a eliminar no existe";
        }
    }
}
