package com.Prendas.TiendaDeRopa.Servicios;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    //Metodo que me trae un objeto de tipo Empresa cuando cuento con el id de la misma
    public Empresa getEmpresaById(Long id_empresa){
        return repositorio.findById(id_empresa).get();
    }


    public Boolean crearEmpresa(Empresa empresa){
        if(!buscarEmpresa(empresa.getId_empresa()).isPresent()) {
            repositorio.save(empresa);
            return true;
        }
        else {
            return false;
        }
    }
    @PatchMapping("/{id_empresa}")
    public Boolean actualizarEmpresa(@PathVariable("id_empresa") Long id_empresa, Empresa empresa){
        Optional<Empresa> dbdata= repositorio.findById(id_empresa);
        if(dbdata.isPresent()) {
            Empresa company=dbdata.get();
            company.setNombre(empresa.getNombre());
            company.setDireccion(empresa.getDireccion());
            company.setTelefono(empresa.getTelefono());
            company.setId_empresa(empresa.getId_empresa());
            company.setDocumento(empresa.getDocumento());
            //company.setCreatedAt(empresa.getCreatedAt());
            company.setUpdatedAt(empresa.getUpdatedAt());

            System.out.println(company+" "+company.getCreatedAt());
            this.repositorio.save(company);

            return true;
        }
        return false;
    }



    public Boolean eliminarEmpresa(Long id_empresa){
        if(buscarEmpresa(id_empresa).isPresent()){
            repositorio.deleteAllById(Collections.singleton(id_empresa));
            return true;
        }
        else {
            return false;
        }
    }
}

