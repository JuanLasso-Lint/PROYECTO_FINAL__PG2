package org.uniquindio.edu.co.poo.proyecto_final.model;

public class Pedido {

    private Tarifa tarifa;
    private CalculoTarifaStrategy estrategia;

    public Pedido(Tarifa tarifa, CalculoTarifaStrategy estrategia) {
        this.tarifa = tarifa;
        this.estrategia = estrategia;
    }

    public double calcularPrecio() {
        return estrategia.calcular(tarifa);
    }
}