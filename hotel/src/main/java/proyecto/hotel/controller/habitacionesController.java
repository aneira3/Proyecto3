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

import proyecto.hotel.model.habitaciones;
import proyecto.hotel.repository.habitacionesRepository;

@Controller
public class habitacionesController {
    @Autowired
    private habitacionesRepository Rep;
    
    @RequestMapping("/habitaciones")
    public String requerimiento2(Model model, String tipo) {
        if ( tipo==null||tipo.equals("")){
        model.addAttribute("INFO", Rep.findAll());
        }
        else{
            int numero = Integer.parseInt(tipo);
        model.addAttribute("INFO", Rep.findByNumero(numero));
        }
        return "habitaciones"; 
    }

    @GetMapping("/habitaciones/new")
    public String barForm(Model model) {
        model.addAttribute("habitacion", new habitaciones());
        return "habitacionesNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String barGuardar(@ModelAttribute habitaciones entidad) {
        Rep.insert(entidad);
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String barEditarForm(@PathVariable("id") String id, Model model) {
        Optional<habitaciones> opcional  = Rep.findById(id);
        habitaciones entidad = opcional.get();
        if (entidad != null) {
            model.addAttribute("habitacion", entidad);
            return "habitacionesEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String barEditarGuardar(@PathVariable("id") String id, @ModelAttribute habitaciones objeto) {
        habitaciones entity = new habitaciones(id, objeto.getNumero_habitacion(), objeto.getCosto(), objeto.getTipo(), objeto.getCapacidad());
        Rep.save(entity);
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String barEliminar(@PathVariable("id") String id) {
        Rep.deleteById(id);
        return "redirect:/habitaciones";
    }
    
}
