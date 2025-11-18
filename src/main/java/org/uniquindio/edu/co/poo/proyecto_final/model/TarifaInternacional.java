package org.uniquindio.edu.co.poo.proyecto_final.model;

public class TarifaInternacional implements CalculoTarifaStrategy {

    @Override
    public double calcular(Tarifa tarifa) {
        double base = (tarifa.getPeso() * 3000) + (tarifa.getVolumen() * 2500);

        double multDistancia = switch (tarifa.getDistancia()) {
            case CERCA -> 2.0;
            case MODERADA -> 2.5;
            case LEJANA -> 3.0;
        };

        double multPrioridad = switch (tarifa.getPrioridad()) {
            case BAJA -> 1.2;
            case MEDIA -> 1.5;
            case ALTA -> 1.9;
        };

        double precio = base * multDistancia * multPrioridad;
        return precio + tarifa.getRecargo() + 15000; // recargo internacional
    }
}
