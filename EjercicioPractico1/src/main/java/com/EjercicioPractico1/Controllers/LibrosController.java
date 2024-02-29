package com.EjercicioPractico1.Controllers;


import com.EjercicioPractico1.Service.LibrosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/libros")
public class LibrosController {
    
    @Autowired
    private LibrosService LibrosService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var Libros = LibrosService.getlibros(false);
        model.addAttribute("Libros", Libros);
        model.addAttribute("totalCategorias", Libros.size());
        return "/Libros/listado";
    }
}