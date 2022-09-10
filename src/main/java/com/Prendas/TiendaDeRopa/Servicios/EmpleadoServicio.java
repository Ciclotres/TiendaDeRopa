package com.Prendas.TiendaDeRopa.Servicios;


import com.Prendas.TiendaDeRopa.Entidades.Empleado;
import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Repositorio.EmpleadoRepositorio;
import com.Prendas.TiendaDeRopa.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    @PatchMapping("/{id_empleado}")
    public Empleado actualizarEmpleado(@PathVariable("id_empleado") Long id_empleado, @RequestBody Empleado empleado) {
        Optional<Empleado> dbdata = repositorio.findById(id_empleado);
        if (dbdata.isPresent()) {
            Empleado empleados = dbdata.get();
            empleados.setCorreo(empleado.getCorreo());
            empleados.setRol(empleado.getRol());
            empleados.setEmpresa(empleado.getEmpresa());
            empleados.setPerfil(empleado.getPerfil());
            empleados.setCreatedAt(empleado.getCreatedAt());
            empleados.setUpdatedAt(empleado.getUpdatedAt());


            this.repositorio.save(empleados);
            return empleados;
        }
        return null;
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
