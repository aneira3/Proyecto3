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

import proyecto.hotel.model.tipoHabitacion;
import proyecto.hotel.repository.tipoHabitacionRepository;

@Controller
public class TipoHabitacionController {

    @Autowired
    private tipoHabitacionRepository tipoRep;
    
    @RequestMapping("/tipos")
    public String requerimiento2(Model model, String tipo) {
        if ( tipo==null||tipo.equals("")){
        model.addAttribute("INFO", tipoRep.findAll());
        }
        else{
        model.addAttribute("INFO", tipoRep.findByTipo(tipo));
        }
        return "tipoHabitacion"; 
    }

    
    @GetMapping("/tipos/new")
    public String barForm(Model model) {
        model.addAttribute("tipo", new tipoHabitacion());
        return "tipoHabitacionNuevo";
    }

    @PostMapping("/tipos/new/save")
    public String barGuardar(@ModelAttribute tipoHabitacion tipo) {
        tipoRep.insert(tipo);
        return "redirect:/tipos";
    }

    @GetMapping("/tipos/{id}/edit")
    public String barEditarForm(@PathVariable("id") String id, Model model) {
        Optional<tipoHabitacion> tipo  = tipoRep.findById(id);
        tipoHabitacion Tipo = tipo.get();
        if (Tipo != null) {
            model.addAttribute("tipo", Tipo);
            return "tipoHabitacionEditar";
        } else {
            return "redirect:/tipos";
        }
    }

    @PostMapping("/tipos/{id}/edit/save")
    public String barEditarGuardar(@PathVariable("id") String id, @ModelAttribute tipoHabitacion tipo) {
        tipoHabitacion entity = new tipoHabitacion(id, tipo.getTipo(), tipo.getCosto(), tipo.getAmenidades());
        tipoRep.save(entity);
        return "redirect:/tipos";
    }

    @GetMapping("/tipos/{id}/delete")
    public String barEliminar(@PathVariable("id") String id) {
        tipoRep.deleteById(id);
        return "redirect:/tipos";
    }
    
}
