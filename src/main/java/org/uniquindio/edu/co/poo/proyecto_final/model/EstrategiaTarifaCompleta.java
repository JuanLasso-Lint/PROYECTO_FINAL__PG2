package org.uniquindio.edu.co.poo.proyecto_final.model;

public class EstrategiaTarifaCompleta implements CalculoTarifaStrategy {

    @Override
    public double calcular(Tarifa tarifa) {

        double precioBase = (tarifa.getPeso() * 2000) + (tarifa.getVolumen() * 1500);

        double multiplicadorDistancia = switch (tarifa.getDistancia()) {
            case CERCA -> 1.0;
            case MODERADA -> 1.5;
            case LEJANA -> 2.0;
        };

        double multiplicadorPrioridad = switch (tarifa.getPrioridad()) {
            case BAJA -> 1.0;
            case MEDIA -> 1.3;
            case ALTA -> 1.6;
        };

        return precioBase * multiplicadorDistancia * multiplicadorPrioridad + tarifa.getRecargo();
    }
}
