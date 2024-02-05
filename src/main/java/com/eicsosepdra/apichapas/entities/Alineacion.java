package com.eicsosepdra.apichapas.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Alineacion")
public class Alineacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idJugador")
    private Jugador jugador;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Alineacion_Chapa",
            joinColumns = @JoinColumn(name = "idAlineacion"),
            inverseJoinColumns = @JoinColumn(name = "idChapa"))
    private List<Chapa> chapas;

    @Column(nullable = false)
    private int zonaIV;

    @Column(nullable = false)
    private int zonaIII;

    @Column(nullable = false)
    private int zonaII;

    @Column(nullable = false)
    private int zonaI;
}
