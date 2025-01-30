package edu.badpals.contador_votos.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate data;
    private LocalTime hora;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pelicula")
    private Pelicula pelicula;

    public Voto() {
    }

    public Voto(LocalDate data, LocalTime hora, Usuario usuario, Pelicula pelicula) {
        this.data = data;
        this.hora = hora;
        this.usuario = usuario;
        this.pelicula = pelicula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Voto voto)) return false;
        return id == voto.id && Objects.equals(data, voto.data) && Objects.equals(hora, voto.hora) && Objects.equals(usuario, voto.usuario) && Objects.equals(pelicula, voto.pelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, hora, usuario, pelicula);
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", data=" + data +
                ", hora=" + hora +
                ", usuario=" + usuario +
                ", pelicula=" + pelicula +
                '}';
    }
}
