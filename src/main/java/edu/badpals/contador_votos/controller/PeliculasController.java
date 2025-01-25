package edu.badpals.contador_votos.controller;

import edu.badpals.contador_votos.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PeliculasController {

    private List<Pelicula> peliculas;

    public PeliculasController(){
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("Indiana Jones en busca del Arca perdida","arca"));
        peliculas.add(new Pelicula("El cielo sobre Berlín","berlin"));
        peliculas.add(new Pelicula("El imperio contraataca","imperio"));
        peliculas.add(new Pelicula("Alien: el octavo pasajero","alien"));
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("peliculas", peliculas);
        return "index";
    }

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

}
