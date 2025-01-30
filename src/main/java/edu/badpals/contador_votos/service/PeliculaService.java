package edu.badpals.contador_votos.service;

import edu.badpals.contador_votos.model.entities.Pelicula;
import edu.badpals.contador_votos.model.repository.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculasRepository peliculasRepository;

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

}
