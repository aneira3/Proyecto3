package proyecto.hotel.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.hotel.model.serviciosReservables;
import proyecto.hotel.repository.reservaServicioRepository;
import proyecto.hotel.repository.serviciosReservablesRepository;

@Controller
public class ServiciosController {

    //TODO limitar lista
    //TODO agregar productos
    @Autowired
    private serviciosReservablesRepository servicioRep;

    @Autowired
    private reservaServicioRepository res;
    
    @RequestMapping("/servicios")
    public String requerimiento2(Model model, String tipo) {
        if ( tipo==null||tipo.equals("")){
        model.addAttribute("INFO", servicioRep.findAll());
        }
        else{
        model.addAttribute("INFO", servicioRep.findByTipo(tipo));
        }
        return "servicios"; 
    }

    @GetMapping("/servicios/new")
    public String barForm(Model model) {
        model.addAttribute("servicio", new serviciosReservables());
        return "servicioNuevo";
    }

    @GetMapping("/servicios/req1")
    public String req1(Model model) {
        model.addAttribute("req", res.getRequerimiento1("2023-01-01", "2024-01-01"));
        return "requerimiento1";
    }

    @GetMapping("/servicios/req3")
    public String req3(Model model, String documento, String fecha1, String fecha2) {
        if((documento == null || documento.equals("") || fecha1 == null || fecha1.equals("") ) && (fecha2 == null || fecha2.equals("")) )
        {
            model.addAttribute("INFO", res.darReservas());
        }
        else
        {
            model.addAttribute("INFO", res.req3(documento, fecha1, fecha2));
        }
        return "requerimiento3";
    }

    @PostMapping("/servicios/new/save")
    public String barGuardar(@ModelAttribute serviciosReservables servicio) {
        servicioRep.insert(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String barEditarForm(@PathVariable("id") String id, Model model) {
        Optional<serviciosReservables> servicio  = servicioRep.findById(id);
        serviciosReservables Servicio = servicio.get();
        if (Servicio != null) {
            model.addAttribute("servicio", Servicio);
            return "serviciosEditar";
        } else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String barEditarGuardar(@PathVariable("id") String id, @ModelAttribute serviciosReservables servicio) {
        serviciosReservables entity = new serviciosReservables(id, servicio.getTipo(), servicio.getCosto_por_horas(), servicio.getCapacidad());
        servicioRep.save(entity);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String barEliminar(@PathVariable("id") String id) {
        servicioRep.deleteById(id);
        return "redirect:/servicios";
    }

}
