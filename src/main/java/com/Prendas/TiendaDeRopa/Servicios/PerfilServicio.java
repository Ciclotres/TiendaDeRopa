package com.Prendas.TiendaDeRopa.Servicios;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Entidades.Perfil;
import com.Prendas.TiendaDeRopa.Repositorio.EmpleadoRepositorio;
import com.Prendas.TiendaDeRopa.Repositorio.PerfilRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PerfilServicio {
    private PerfilRepositorio repositorio;

    public PerfilServicio(PerfilRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public ArrayList<Perfil> listarPerfil(){
        return (ArrayList<Perfil>) repositorio.findAll();
    }
    public Optional<Perfil> buscarPerfil(String id_perfil){
        return repositorio.findById(id_perfil);
    }

    public String crearPerfil(Perfil perfil){
        if(!buscarPerfil(perfil.getId_perfil()).isPresent()) {
            repositorio.save(perfil);
            return "Perfil registrado exitosamente";
        }
        else {
            return "Perfil ya existe.";
        }
    }
}
