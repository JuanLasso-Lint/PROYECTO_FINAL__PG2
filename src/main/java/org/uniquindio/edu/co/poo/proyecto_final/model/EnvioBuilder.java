package org.uniquindio.edu.co.poo.proyecto_final.model;

import javafx.util.Builder;

import java.time.LocalDate;
import java.util.List;

public class EnvioBuilder {

    private String idEnvio;
    private String estadoEnvio;
    private LocalDate fechaCreacion;
    private LocalDate fechaEstimadaEntrega;
    private List<Incidencia> listaInciencias;
    private Repartidor repartidor;
    private Usuario usuario;
    private Direccion direccion;
    private Tarifa tarifa;

    private EnvioBuilder(Builder builder) {
        this.idEnvio = builder.idEnvio;
        this.estadoEnvio = builder.estadoEnvio;
        this.fechaCreacion = builder.fechaCreacion;
        this.fechaEstimadaEntrega = builder.fechaEstimadaEntrega;
        this.listaInciencias = builder.listaInciencias;
        this.repartidor = builder.repartidor;
        this.usuario = builder.usuario;
        this.direccion = builder.direccion;
        this.tarifa = builder.tarifa;
    }

    @Override
    public String toString() {
        return "EnvioBuilder{" +
                "idEnvio='" + idEnvio + '\'' +
                ", estadoEnvio='" + estadoEnvio + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaEstimadaEntrega=" + fechaEstimadaEntrega +
                ", listaInciencias=" + listaInciencias +
                ", repartidor=" + repartidor +
                ", usuario=" + usuario +
                ", direccion=" + direccion +
                ", tarifa=" + tarifa +
                '}';
    }

    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(LocalDate fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public List<Incidencia> getListaInciencias() {
        return listaInciencias;
    }

    public void setListaInciencias(List<Incidencia> listaInciencias) {
        this.listaInciencias = listaInciencias;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public static class Builder {


        //Se usa final para que se obligatorio usar estos atributos posteriormente se los crea en el constructor
        private final String idEnvio;
        private final String estadoEnvio;
        private final LocalDate fechaCreacion;
        private final Direccion direccion;
        private final Tarifa tarifa;


        private LocalDate fechaEstimadaEntrega;
        private List<Incidencia> listaInciencias;
        private Repartidor repartidor;
        private Usuario usuario;


        //Constructor con los atributos obligatorios
        public Builder(String idEnvio, String estadoEnvio, LocalDate fechaCreacion,  Direccion direccion, Tarifa tarifa) {
            this.idEnvio = idEnvio;
            this.estadoEnvio = estadoEnvio;
            this.fechaCreacion = fechaCreacion;
            this.direccion = direccion;
            this.tarifa = tarifa;

        }

        public Builder fechaEstimadaEntrega(LocalDate fechaEstimadaEntrega) {
            this.fechaEstimadaEntrega = fechaEstimadaEntrega;
            return this;
        }

        public Builder ListaInciencias(List<Incidencia> listaInciencias) {
            this.listaInciencias = listaInciencias;
            return this;
        }

        public Builder repartidor(Repartidor repartidor) {
            this.repartidor = repartidor;
            return this;
        }

        public Builder usuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public EnvioBuilder build() {
            return new EnvioBuilder(this);
        }




    }




}
