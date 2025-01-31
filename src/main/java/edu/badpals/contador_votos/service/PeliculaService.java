package edu.badpals.contador_votos.service;

import edu.badpals.contador_votos.model.entities.Pelicula;
import edu.badpals.contador_votos.model.entities.Usuario;
import edu.badpals.contador_votos.model.repository.PeliculasRepository;
import edu.badpals.contador_votos.model.repository.UsuarioRepository;
import edu.badpals.contador_votos.model.repository.VotoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {


    private PeliculasRepository peliculasRepository;

    @Autowired
    public PeliculaService(PeliculasRepository peliculasRepository) {
        this.peliculasRepository = peliculasRepository;
        peliculasRepository.save(new Pelicula("Indiana Jones en busca del Arca perdida","arca.jpg"));
        peliculasRepository.save(new Pelicula("El cielo sobre Berlín","berlin.jpg"));
        peliculasRepository.save(new Pelicula("El imperio contraataca","imperio.jpg"));
        peliculasRepository.save(new Pelicula("Alien: el octavo pasajero","alien.jpg"));
    }

    public List<Pelicula> getAllPeliculas(){
        return peliculasRepository.findAll();
    }

    public Pelicula getPeliculaById(int id){
        return peliculasRepository.findById(id).get();
    }

}
