package org.uniquindio.edu.co.poo.proyecto_final.model;

public class Tarifa {

    private TipoDistancia distancia;
    private double peso;
    private double volumen;
    private TipoProridad prioridad;
    private double recargoAdicional;

    public Tarifa (double peso, double volumen, TipoProridad prioridad, int recargoAdicional, TipoDistancia distancia) {
        this.peso = peso;
        this.volumen = volumen;
        this.prioridad = prioridad;
        this.recargoAdicional = recargoAdicional;
        this.distancia = distancia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public TipoDistancia getDistancia() {
        return distancia;
    }

    public void setDistancia(TipoDistancia distancia) {
        this.distancia = distancia;
    }

    public TipoProridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(TipoProridad prioridad) {
        this.prioridad = prioridad;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getRecargoAdicional() {
        return recargoAdicional;
    }

    public void setRecargoAdicional(double recargoAdicional) {
        this.recargoAdicional = recargoAdicional;
    }

    public double CalculoTarifa(double peso, double volumen, TipoProridad prioridad, double recargoAdicional, TipoDistancia distancia) {

        double precioBase = (peso * 2000) + (volumen * 1500);

        double multiplicadorDistancia = switch (distancia) {
            case CERCA -> 1.0;
            case MODERADA -> 1.5;
            case LEJANA -> 2.0;
        };

        double multiplicadorPrioridad = switch (prioridad) {
            case BAJA -> 1.0;
            case MEDIA -> 1.3;
            case ALTA -> 1.6;
        };

        double precio = precioBase * multiplicadorDistancia * multiplicadorPrioridad + recargoAdicional;

        return precio;

    }

}
