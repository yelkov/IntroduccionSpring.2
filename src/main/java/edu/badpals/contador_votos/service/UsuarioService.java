package edu.badpals.contador_votos.service;

import edu.badpals.contador_votos.model.entities.Pelicula;
import edu.badpals.contador_votos.model.entities.Usuario;
import edu.badpals.contador_votos.model.entities.Voto;
import edu.badpals.contador_votos.model.repository.PeliculasRepository;
import edu.badpals.contador_votos.model.repository.UsuarioRepository;
import edu.badpals.contador_votos.model.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class UsuarioService {


    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuarioConVoto(String email, Pelicula pelicula) throws IllegalArgumentException {
        Usuario usuarioExiste = usuarioRepository.findByEmail(email);
        if(usuarioExiste != null){
            anadirVoto(usuarioExiste,pelicula);
        }
        Usuario usuario = new Usuario(email);
        Voto voto = new Voto(LocalDate.now(),LocalTime.now(),usuario,pelicula);
        usuario.setVoto(voto);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario anadirVoto(Usuario usuario, Pelicula pelicula) throws IllegalArgumentException {
        Usuario usuarioNuevo = usuarioRepository.findById(usuario.getId()).orElse(null);
        if(usuarioNuevo == null){
            throw new IllegalArgumentException("El usuario no existe");
        }
        if(usuarioNuevo.getVoto() != null){
            throw new IllegalArgumentException("El usuario ya ha votado previamente");
        }
        Voto voto = new Voto(LocalDate.now(),LocalTime.now(),usuario,pelicula);
        usuarioNuevo.setVoto(voto);
        usuarioRepository.save(usuarioNuevo);
        return usuarioNuevo;
    }

}
