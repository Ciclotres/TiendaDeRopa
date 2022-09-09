package com.Prendas.TiendaDeRopa.Servicios;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class EmpresaServicio {
    private EmpresaRepositorio repositorio;
    public EmpresaServicio(EmpresaRepositorio repositorio){
        this.repositorio=repositorio;
    }
    public ArrayList<Empresa> listarEmpresa(){
        return (ArrayList<Empresa>) repositorio.findAll();
    }
  //no sabemos como buscar con tipo long
   public Optional<Empresa> buscarEmpresa(long id_empresa){
        return repositorio.findById(id_empresa);
   }
    public String crearEmpresa(Empresa empresa){
        if(!buscarEmpresa(empresa.getId_empresa()).isPresent()) {
            repositorio.save(empresa);
            return "Empresa registrada exitosamente";
        }
        else {
            return "La empresa ya existe.";
        }
    }
    public String actualizarEmpresa(Long id_empresa){
        if (buscarEmpresa(id_empresa).isPresent()){
            Empresa empresa=repositorio.findById(id_empresa).get();
            repositorio.save(empresa);
            return "Empresa Actualizada";
        }
        else {
            return "La empresa a actualizar no existe";
        }
}
    public String eliminarEmpresa(Long id_empresa){
        if(buscarEmpresa(id_empresa).isPresent()){
            repositorio.deleteAllById(Collections.singleton(id_empresa));
            return "Empresa eliminada";
        }
        else {
            return "La empresa a eliminar no existe";
        }
    }
}

