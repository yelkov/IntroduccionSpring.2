package edu.badpals.contador_votos;

import edu.badpals.contador_votos.model.entities.Pelicula;
import edu.badpals.contador_votos.model.entities.Usuario;
import edu.badpals.contador_votos.model.entities.Voto;
import edu.badpals.contador_votos.model.repository.PeliculasRepository;
import edu.badpals.contador_votos.model.repository.UsuarioRepository;
import edu.badpals.contador_votos.model.repository.VotoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class ContadorVotosApplication{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PeliculasRepository peliculasRepository;

	@Autowired
	private VotoRepository votoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContadorVotosApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PeliculasRepository peliculasRepository, UsuarioRepository usuarioRepository, VotoRepository votoRepository) {
		return (args)->{

		};
	}

}
