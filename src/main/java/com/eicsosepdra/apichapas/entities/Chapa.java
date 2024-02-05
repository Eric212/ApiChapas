package com.eicsosepdra.apichapas.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Chapas")
public class Chapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id;

    @Column(length = 45)
    private String nombre;

    @Column(length = 45)
    private String apellido;

    @Column(length = 45)
    private String posicion;

    @Column
    private double valor;

    @Column
    private int nivel;

    @Column
    private int vida;

    @Column(length = 11)
    private int victorias;

    @ManyToMany(mappedBy = "chapas")
    private List<Jugador> jugadores;

}
