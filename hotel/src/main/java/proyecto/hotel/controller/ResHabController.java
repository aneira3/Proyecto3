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

import proyecto.hotel.model.Cliente;
import proyecto.hotel.model.reservaHabitacion;
import proyecto.hotel.repository.reservaHabitacionRepository;

@Controller
public class ResHabController {
    
    @Autowired
    private reservaHabitacionRepository Rep;
    
    @RequestMapping("/ResHab")
    public String requerimiento2(Model model, String tipo) {
        if ( tipo==null||tipo.equals("")){
        model.addAttribute("INFO", Rep.findAll());
        }
        else{
        model.addAttribute("INFO", Rep.findByNombre(tipo));
        }
        return "ResHab"; 
    }

    @GetMapping("/ResHab/new")
    public String barForm(Model model) {
        reservaHabitacion entidad = new reservaHabitacion();
        Cliente embebido = new Cliente();
        entidad.setCliente(embebido);
        model.addAttribute("habitacion", entidad);
        model.addAttribute("cliente", embebido);
        return "ResHabNuevo";
    }

    @PostMapping("/ResHab/new/save")
    public String barGuardar(@ModelAttribute reservaHabitacion entidad) {
        Rep.insert(entidad);
        return "redirect:/ResHab";
    }

    @GetMapping("/ResHab/{id}/edit")
    public String barEditarForm(@PathVariable("id") String id, Model model) {
        Optional<reservaHabitacion> opcional  = Rep.findById(id);
        reservaHabitacion entidad = opcional.get();
        if (entidad != null) {
            model.addAttribute("habitacion", entidad);
            model.addAttribute("cliente", entidad.getCliente());
            return "ResHabEditar";
        } else {
            return "redirect:/ResHab";
        }
    }

    @PostMapping("/ResHab/{id}/edit/save")
    public String barEditarGuardar(@PathVariable("id") String id, @ModelAttribute reservaHabitacion objeto) {
        reservaHabitacion entity = new reservaHabitacion(id, objeto.getFechaEntrada(), objeto.getFechaSalida(), objeto.getCosto_total(), objeto.getNumero_habitacion(), objeto.getPlan_consumo(), objeto.getCliente());
        Rep.save(entity);
        return "redirect:/ResHab";
    }

    @GetMapping("/ResHab/{id}/delete")
    public String barEliminar(@PathVariable("id") String id) {
        Rep.deleteById(id);
        return "redirect:/ResHab";
    }
    
}
