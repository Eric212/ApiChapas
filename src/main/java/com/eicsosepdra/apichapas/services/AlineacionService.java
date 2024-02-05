package com.eicsosepdra.apichapas.services;

import com.eicsosepdra.apichapas.entities.Alineacion;
import com.eicsosepdra.apichapas.entities.Chapa;
import com.eicsosepdra.apichapas.entities.Jugador;
import com.eicsosepdra.apichapas.repositories.AlineacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlineacionService {

    @Autowired
    private AlineacionRepository alineacionRepository;

    public Alineacion crearAlineacion(Jugador jugador, List<Chapa> chapas) {
        int zonaIV = (int) chapas.stream().filter(chapa -> chapa.getPosicion().equals("Zona IV")).count();
        int zonaIII = (int) chapas.stream().filter(chapa -> chapa.getPosicion().equals("Zona III")).count();
        int zonaII = (int) chapas.stream().filter(chapa -> chapa.getPosicion().equals("Zona II")).count();
        int zonaI = (int) chapas.stream().filter(chapa -> chapa.getPosicion().equals("Zona I")).count();

        if (!(zonaIV >= 2 && zonaIV <= 3 && zonaIII >= 3 && zonaIII <= 4
                && zonaII >= 3 && zonaII <= 4 && zonaI >= 1 && zonaI <= 2 && chapas.size() == 11)) {
            System.err.println("La alineación no cumple con las restricciones requeridas.");
        }

        Alineacion alineacion = new Alineacion();
        alineacion.setJugador(jugador);
        alineacion.setChapas(chapas);
        alineacion.setZonaIV(zonaIV);
        alineacion.setZonaIII(zonaIII);
        alineacion.setZonaII(zonaII);
        alineacion.setZonaI(zonaI);

        return alineacionRepository.save(alineacion);
    }
}
