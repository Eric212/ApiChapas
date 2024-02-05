package com.eicsosepdra.apichapas.entities;

import java.util.List;
import java.util.Random;

public class Combate {

    public void realizarCombate(Alineacion alineacion1, Alineacion alineacion2, int numeroDeTurnos) {
        for (int turno = 1; turno <= numeroDeTurnos; turno++) {
            System.out.println("Turno " + turno + ":");

            // Realizar tiradas y calcular daño
            int resultadoAlineacion1 = calcularResultado(alineacion1);
            int resultadoAlineacion2 = calcularResultado(alineacion2);

            // Determinar ganador del turno
            Alineacion ganador = (resultadoAlineacion1 > resultadoAlineacion2) ? alineacion1 : alineacion2;

            // Aplicar daño y actualizar estadísticas
            aplicarDamage(ganador, alineacion1, alineacion2);

            // Mostrar estado después del turno
            mostrarEstado(alineacion1, alineacion2);
        }

        // Determinar ganador final
        Alineacion ganadorFinal = determinarGanador(alineacion1, alineacion2);

        // Mostrar resultado final
        System.out.println("Ganador final: " + ganadorFinal.getJugador().getNombre());
    }

    private int calcularResultado(Alineacion alineacion) {
        Random random = new Random();
        int dado = random.nextInt(20) + 1;  // Dado de 20 caras
        Chapa chapaAleatoria = obtenerChapaAleatoria(alineacion);
        int nivelAleatorio = random.nextInt(chapaAleatoria.getNivel()) + 1;
        return dado * nivelAleatorio;
    }

    private Chapa obtenerChapaAleatoria(Alineacion alineacion) {
        Random random = new Random();
        List<Chapa> chapas = alineacion.getChapas();
        return chapas.get(random.nextInt(chapas.size()));
    }

    private void aplicarDamage(Alineacion ganador, Alineacion alineacion1, Alineacion alineacion2) {

    }

    private void mostrarEstado(Alineacion alineacion1, Alineacion alineacion2) {

    }

    private Alineacion determinarGanador(Alineacion alineacion1, Alineacion alineacion2) {
        return (calcularVidaTotal(alineacion1) > calcularVidaTotal(alineacion2)) ? alineacion1 : alineacion2;
    }

    private int calcularVidaTotal(Alineacion alineacion) {
        return alineacion.getChapas().stream().mapToInt(Chapa::getVida).sum();
    }
}
