package proyecto.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.hotel.model.Cliente;
import proyecto.hotel.model.reservaServicio;
import proyecto.hotel.model.serviciosReservables;
import proyecto.hotel.repository.reservaServicioRepository;
import proyecto.hotel.repository.serviciosReservablesRepository;
import proyecto.hotel.repository.reservaServicioRepository.respuesta;

@Controller
public class ResSerController {

    @Autowired
    private reservaServicioRepository Rep;
    
    @Autowired
    private serviciosReservablesRepository ser;

    @RequestMapping("/ResSer")
    public String requerimiento2(Model model, String tipo) {
        List<respuesta> objeto = Rep.darReservas();
        if ( tipo==null||tipo.equals("")){
        model.addAttribute("INFO", objeto );
        }
        else{
        model.addAttribute("INFO", Rep.findByNombre(tipo));
        }
        return "ResSer"; 
    }

    @GetMapping("/ResSer/new")
    public String barForm(Model model) {
        reservaServicio entidad = new reservaServicio();
        List<serviciosReservables> servicios = ser.findAll();
        Cliente embebido = new Cliente();
        entidad.setCliente(embebido);
        model.addAttribute("reserva", entidad);
        model.addAttribute("cliente", embebido);
        model.addAttribute("servicios", servicios);
        return "ResSerNuevo";
    }

    @PostMapping("/ResSer/new/save")
    public String barGuardar(@ModelAttribute reservaServicio entidad) {
       
        Rep.insert(entidad);
        return "redirect:/ResSer";
    }

    @GetMapping("/ResSer/{id}/edit")
    public String barEditarForm(@PathVariable("id") String id, Model model) {
        respuesta entidad  = Rep.findByNombre(id).get(0);
        List<serviciosReservables> servicios = ser.findAll();
        if (entidad != null) {
            model.addAttribute("reserva", entidad);
            model.addAttribute("cliente", entidad.getCliente());
            model.addAttribute("servicios", servicios);
            return "ResSerEditar";
        } else {
            return "redirect:/ResSer";
        }
    }

    @PostMapping("/ResSer/{id}/edit/save")
    public String barEditarGuardar(@PathVariable("id") String id, @ModelAttribute reservaServicio objeto) {
        reservaServicio entity = new reservaServicio(objeto.get_id(), objeto.getFecha(), objeto.getCosto(), objeto.getNumero_habitacion(), objeto.getServicio_reservable(), objeto.getCliente(), objeto.getDuracion());
        Rep.save(entity);
        return "redirect:/ResSer";
    }

    @GetMapping("/ResSer/{id}/delete")
    public String barEliminar(@PathVariable("id") String id) {
        Rep.deleteById(id);
        return "redirect:/ResSer";
    }
    
}
