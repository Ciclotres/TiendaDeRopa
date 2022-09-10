package com.Prendas.TiendaDeRopa.Controlador;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Servicios.EmpresaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class EmpresaControlador {
    private EmpresaServicio servicio;

    public EmpresaControlador(EmpresaServicio servicio) {
        this.servicio = servicio;
    }
    @GetMapping("/ListarEmpresas")
    public ArrayList<Empresa> listar(){
        return servicio.listarEmpresa();
    }

    @GetMapping("/BuscarEmpresa/{id_empresa}")
    public Optional<Empresa> buscarEmpresa(@PathVariable("id_empresa") Long id_empresa){
        return servicio.buscarEmpresa(id_empresa);
    }
    @PostMapping("/CrearEmpresa")
    public String crearEmpresa(@RequestBody Empresa empresa){
        return servicio.crearEmpresa(empresa);
    }
    //MIRAR LO DE ACTUALIZAR CUALQUIER CAMPO  PQ HASTA AHORA SI BUSCA EL ID PERO QUE CAMBIA?

    @PatchMapping("/ActualizarEmpresa/{id_empresa}")
    public Empresa actualizarEmpresa(@PathVariable("id_empresa") Long id_empresa, @RequestBody Empresa empresa){
        return servicio.actualizarEmpresa(id_empresa,empresa);
    }


    @DeleteMapping("/EliminarEmpresa/{id_empresa}")
    public String eliminarEmpresa(@PathVariable("id_empresa") Long id_empresa){
        return servicio.eliminarEmpresa(id_empresa);
    }
}
