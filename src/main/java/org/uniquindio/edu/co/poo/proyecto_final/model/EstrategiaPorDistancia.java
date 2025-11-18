package org.uniquindio.edu.co.poo.proyecto_final.model;

public class EstrategiaPorDistancia implements CalculoTarifaStrategy {

    @Override
    public double calcular(Tarifa tarifa) {
        double base = tarifa.getPeso() * 1500;
        double factor = (tarifa.getDistancia() == TipoDistancia.LEJANA) ? 2.0 :
                (tarifa.getDistancia() == TipoDistancia.MODERADA) ? 1.5 : 1.0;

        return base * factor + tarifa.getRecargo();
    }
}
