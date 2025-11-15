package org.uniquindio.edu.co.poo.proyecto_final.model;

public class Repartidor extends Persona {

    private String idRepartidor;
    private boolean estadoDisponibilidad;
    private String zonaCobertura;


    public Repartidor(String nombre, String identificacion, String telefono, String idRepartidor, boolean estadoDisponibilidad, String zonaCobertura) {
        super(nombre, identificacion, telefono);
        this.idRepartidor = idRepartidor;
        this.estadoDisponibilidad = estadoDisponibilidad;
        this.zonaCobertura = zonaCobertura;
    }

    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public boolean isEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(boolean estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(String zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }
}
