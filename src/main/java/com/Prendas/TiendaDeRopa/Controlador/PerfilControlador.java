package com.Prendas.TiendaDeRopa.Controlador;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Entidades.Perfil;
import com.Prendas.TiendaDeRopa.Servicios.EmpresaServicio;
import com.Prendas.TiendaDeRopa.Servicios.PerfilServicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class PerfilControlador {
    private PerfilServicio servicio;

    public PerfilControlador(PerfilServicio servicio) {
        this.servicio = servicio;
    }
    @GetMapping("/ListarPerfil")
    public ArrayList<Perfil> listar(){
        return servicio.listarPerfil();
    }

    @GetMapping("/BuscarPerfil/{id_perfil}")
    public Optional<Perfil> buscarPerfil(@PathVariable("id_perfil") String id_perfil){
        return servicio.buscarPerfil(id_perfil);
    }
    @PostMapping("/CrearPerfil")
    public String crearPerfil(@RequestBody Perfil perfil){
        return servicio.crearPerfil(perfil);
    }
    //MIRAR LO DE ACTUALIZAR CUALQUIER CAMPO  PQ HASTA AHORA SI BUSCA EL ID PERO QUE CAMBIA?
}
