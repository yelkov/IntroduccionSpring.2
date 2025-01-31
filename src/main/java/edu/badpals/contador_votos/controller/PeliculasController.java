package edu.badpals.contador_votos.controller;

import edu.badpals.contador_votos.model.entities.Pelicula;
import edu.badpals.contador_votos.model.entities.Usuario;
import edu.badpals.contador_votos.service.PeliculaService;
import edu.badpals.contador_votos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PeliculasController {

    private List<Pelicula> peliculas;

    private PeliculaService peliculaService;
    private UsuarioService usuarioService;

    @Autowired
    public PeliculasController(PeliculaService peliculaService, UsuarioService usuarioService) {
        this.peliculaService = peliculaService;
        this.usuarioService = usuarioService;

    }

    @GetMapping("/")
    public String index(Model model){
        peliculas = peliculaService.getAllPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "index";
    }
    @RequestMapping("/votar")
    public String votar(@RequestParam String email, @RequestParam Integer idPelicula, RedirectAttributes redirectAttributes){
        try{
            Pelicula pelicula = peliculaService.getPeliculaById(idPelicula);
            Usuario usuario = usuarioService.crearUsuarioConVoto(email, pelicula);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("mensajeError", "El usuario ya ha votado previamente.");
        }


        return "redirect:/";
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
