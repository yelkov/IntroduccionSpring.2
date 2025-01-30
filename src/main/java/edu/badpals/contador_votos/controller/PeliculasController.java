package edu.badpals.contador_votos.controller;

import edu.badpals.contador_votos.model.entities.Pelicula;
import edu.badpals.contador_votos.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PeliculasController {

    private List<Pelicula> peliculas;
    @Autowired
    private PeliculaService peliculaService;

    public PeliculasController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
        peliculas = peliculaService.getAllPeliculas();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("peliculas", peliculas);
        return "index";
    }

    /*
    @RequestMapping("/votar")
    public String votar(String nombrePelicula, Model model){
        for (Pelicula pelicula : peliculas){
            if(pelicula.getNombre().equals(nombrePelicula)){
                pelicula.incrementVotos();
                break;
            }
        }
        return "redirect:/";
    }
     */

}
