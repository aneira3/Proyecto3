package proyecto.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class requerimiento3Controller {

    @RequestMapping("/requerimiento3")
    public String requerimiento3(Model model) {
        //model.addAttribute("INFO", consumoProductoRepository.buscar());
        return "requerimiento3"; 
    }
    
}
