package org.uniquindio.edu.co.poo.proyecto_final.model;

public class EstrategiaPorPrioridad implements CalculoTarifaStrategy {

    @Override
    public double calcular(Tarifa tarifa) {
        double base = tarifa.getPeso() * 1000;
        double factor = (tarifa.getPrioridad() == TipoPrioridad.ALTA) ? 1.8 :
                (tarifa.getPrioridad() == TipoPrioridad.MEDIA) ? 1.3 : 1.0;

        return base * factor + tarifa.getRecargo();
    }
}