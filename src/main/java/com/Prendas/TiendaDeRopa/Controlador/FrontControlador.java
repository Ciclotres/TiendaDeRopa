package com.Prendas.TiendaDeRopa.Controlador;

import com.Prendas.TiendaDeRopa.Entidades.Empresa;
import com.Prendas.TiendaDeRopa.Servicios.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class FrontControlador {


    @Autowired
    EmpresaServicio empresaServicio;

    public FrontControlador(EmpresaServicio empresaServicio) {
        this.empresaServicio = empresaServicio;
    }

    @GetMapping("/")
    public String index(/*Model model, @AuthenticationPrincipal OidcUser principal*/)
    {
        return "index";


    }

    @GetMapping("/verEmpresas")
    public String verEmpresas(Model model, @ModelAttribute("mensaje") String mensaje/*Model model, @AuthenticationPrincipal OidcUser principal*/)
    {

        List<Empresa> listaEmpresas=empresaServicio.listarEmpresa();
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("mensaje",mensaje);

        return "verEmpresas";


    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje, @ModelAttribute("fecha") String fecha){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);

         LocalDate fechas = LocalDate.now();
          fecha=fechas.toString();
        model.addAttribute("fecha", fecha);



        return "agregarEmpresa";
    }




    @GetMapping("/editarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje, @ModelAttribute("fecha") String fecha){
        Empresa emp=empresaServicio.getEmpresaById(id);
        //Creamos un atributo para el modelo, que se llame igualmente emp y es el que ira al html para llenar o alimentar campos
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje", mensaje);
        LocalDate fechas = LocalDate.now();
        fecha=fechas.toString();
        model.addAttribute("fecha", fecha);


        return "editarEmpresa";
    }


}
