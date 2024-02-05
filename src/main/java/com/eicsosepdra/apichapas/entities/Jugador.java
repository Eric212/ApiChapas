package com.eicsosepdra.apichapas.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id;

    @Column(length = 45,nullable = false)
    private String nombre;

    @Column(length = 45,nullable = false)
    private String apellidos;

    @Column
    private String jugadoricono;

    @Column
    private double dinerojugador;

   @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
   @JoinTable(name = "chapasjugador",
           joinColumns = @JoinColumn(name = "chapa_id"),
           inverseJoinColumns = @JoinColumn(name = "jugador_id"))
   private List<Chapa> chapas;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "alineacionjugador",
            joinColumns = @JoinColumn(name = "chapa_id"),
            inverseJoinColumns = @JoinColumn(name = "jugador_id"))
    private List<Alineacion> alineaciones;
}
