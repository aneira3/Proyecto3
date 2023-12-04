package proyecto.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.hotel.repository.habitacionesRepository;

@Controller
public class requerimiento1Controller {
    @Autowired
    private habitacionesRepository consumoProductoRepository;

   @RequestMapping("/requerimiento1")
    public String requerimiento1(Model model) {
        //model.addAttribute("INFO", consumoProductoRepository.buscar());
        return "requerimiento1"; 
    } 
    
}