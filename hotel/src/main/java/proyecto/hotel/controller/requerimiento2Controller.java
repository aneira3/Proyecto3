package proyecto.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class requerimiento2Controller {
    

    @RequestMapping("/requerimiento2")
    public String requerimiento2(Model model) {
        //model.addAttribute("INFO", consumoProductoRepository.buscar());
        return "requerimiento2"; 
    }
}
