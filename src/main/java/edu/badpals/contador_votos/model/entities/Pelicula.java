package edu.badpals.contador_votos.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String imagen;

    @OneToMany(mappedBy = "pelicula",fetch = FetchType.EAGER)
    private List<Voto> votos = new ArrayList<>();

    public Pelicula(){}

    public Pelicula(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public void addVoto(Voto voto) {
        this.votos.add(voto);
    }

    public String getImagen() {
        return "/img/" + imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pelicula pelicula)) return false;
        return id == pelicula.id && Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", votos=" + votos +
                '}';
    }
}
