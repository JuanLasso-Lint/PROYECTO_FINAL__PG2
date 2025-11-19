package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;
import java.util.List;

public class Repartidor extends Persona {

    private String idRepartidor;
    private EstadoRepartidor estadoDisponibilidad;
    private String zonaCobertura;
    private List<EnvioBuilder> listEnviosDelRepartidor;


    public Repartidor(String nombre, String identificacion, String telefono, String idRepartidor, EstadoRepartidor estadoDisponibilidad, String zonaCobertura) {
        super(nombre, identificacion, telefono);
        this.idRepartidor = idRepartidor;
        this.estadoDisponibilidad = estadoDisponibilidad;
        this.zonaCobertura = zonaCobertura;
        this.listEnviosDelRepartidor = new ArrayList<EnvioBuilder>();
    }

    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public EstadoRepartidor getEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(EstadoRepartidor estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(String zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }

    public List<EnvioBuilder> getListEnviosDelRepartidor() {
        return listEnviosDelRepartidor;
    }

    public void setListEnviosDelRepartidor(List<EnvioBuilder> listEnviosDelRepartidor) {
        this.listEnviosDelRepartidor = listEnviosDelRepartidor;
    }


    public void agregarListaEnviosDelRepartidor(EnvioBuilder envio) {
        listEnviosDelRepartidor.add(envio);

    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "idRepartidor='" + idRepartidor + '\'' +
                ", estadoDisponibilidad=" + estadoDisponibilidad +
                ", zonaCobertura='" + zonaCobertura + '\'' +
                ", listEnviosDelRepartidor=" + listEnviosDelRepartidor +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}


