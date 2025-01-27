package edu.badpals.contador_votos.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
@NoArgsConstructor
@Setter
@Getter
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String imagen;

    @OneToMany(mappedBy = "pelicula")
    private List<Voto> votos;

    public Pelicula(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getImagen() {
        return "/img/" + imagen;
    }
}
