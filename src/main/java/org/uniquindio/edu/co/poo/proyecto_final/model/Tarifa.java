package org.uniquindio.edu.co.poo.proyecto_final.model;

import org.uniquindio.edu.co.poo.proyecto_final.model.CalculoTarifaStrategy;
import org.uniquindio.edu.co.poo.proyecto_final.model.TipoDistancia;
import org.uniquindio.edu.co.poo.proyecto_final.model.TipoPrioridad;

public class Tarifa {

    private double peso;
    private double volumen;
    private double recargo;
    private TipoPrioridad prioridad;
    private TipoDistancia distancia;

    private CalculoTarifaStrategy estrategia;

    // Constructor vacío (lo mantengo tal cual)
    public Tarifa() {}

    // ✔ Constructor que te faltaba (ARREGLA EL ERROR)
    public Tarifa(double peso, double volumen, TipoPrioridad prioridad,
                  double recargo, TipoDistancia distancia) {

        this.peso = peso;
        this.volumen = volumen;
        this.prioridad = prioridad;
        this.recargo = recargo;
        this.distancia = distancia;
    }

    // SETTERS
    public void setPeso(double peso) { this.peso = peso; }
    public void setVolumen(double volumen) { this.volumen = volumen; }
    public void setRecargo(double recargo) { this.recargo = recargo; }
    public void setPrioridad(TipoPrioridad prioridad) { this.prioridad = prioridad; }
    public void setDistancia(TipoDistancia distancia) { this.distancia = distancia; }

    // GETTERS
    public double getPeso() { return peso; }
    public double getVolumen() { return volumen; }
    public double getRecargo() { return recargo; }
    public TipoPrioridad getPrioridad() { return prioridad; }
    public TipoDistancia getDistancia() { return distancia; }

    // Strategy
    public void setEstrategia(CalculoTarifaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double CalculoTarifa() {
        return estrategia.calcular(this);
    }
}
