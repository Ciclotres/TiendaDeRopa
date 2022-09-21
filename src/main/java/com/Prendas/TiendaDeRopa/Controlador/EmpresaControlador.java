package com.Prendas.TiendaDeRopa.Controlador;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Servicios.EmpresaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Optional;

@Controller
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
    public String crearEmpresa(Empresa emp, RedirectAttributes redirectAttributes)
    {
        if(servicio.crearEmpresa(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/verEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/agregarEmpresa";



       // return servicio.crearEmpresa(empresa);


    }
    //MIRAR LO DE ACTUALIZAR CUALQUIER CAMPO  PQ HASTA AHORA SI BUSCA EL ID PERO QUE CAMBIA?

    @PostMapping("/ActualizarEmpresa/{id_empresa}")
    public String actualizarEmpresa(@PathVariable("id_empresa") Long id_empresa,@ModelAttribute("emp") Empresa emp, RedirectAttributes redirectAttributes){
       // return servicio.actualizarEmpresa(id_empresa,emp);

        if(servicio.actualizarEmpresa(id_empresa,emp)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/verEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/editarEmpresa";


    }


    @GetMapping("/EliminarEmpresa/{id_empresa}")
    public String eliminarEmpresa(@PathVariable("id_empresa") Long id_empresa,RedirectAttributes redirectAttributes){

        if (servicio.eliminarEmpresa(id_empresa)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/verEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/verEmpresas";


    }
}
