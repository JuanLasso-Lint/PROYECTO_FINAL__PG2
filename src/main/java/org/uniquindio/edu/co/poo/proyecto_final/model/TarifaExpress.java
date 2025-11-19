package org.uniquindio.edu.co.poo.proyecto_final.model;

public class TarifaExpress implements CalculoTarifaStrategy {

    @Override
    public double calcular(Tarifa tarifa) {
        double base = (tarifa.getPeso() * 2000) + (tarifa.getVolumen() * 1500);

        double multDistancia = switch (tarifa.getDistancia()) {
            case CERCA -> 1.2;
            case MODERADA -> 1.6;
            case LEJANA -> 2.2;
        };

        double multPrioridad = switch (tarifa.getPrioridad()) {
            case BAJA -> 1.1;
            case MEDIA -> 1.4;
            case ALTA -> 1.7;
        };

        double precio = base * multDistancia * multPrioridad;
        return precio + tarifa.getRecargo() + 5000; // recargo fijo express
    }
}

