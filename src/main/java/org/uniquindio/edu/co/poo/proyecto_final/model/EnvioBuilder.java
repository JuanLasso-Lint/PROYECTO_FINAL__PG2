package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class EnvioBuilder implements IEnvio {

    private String idEnvio;
    private String estadoEnvio;
    private LocalDate fechaCreacion;
    private LocalDate fechaEstimadaEntrega;
    private LocalDateTime fechaHoraSalida;
    private LocalDateTime fechaHoraEntregaReal;
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
        this.fechaHoraSalida = builder.fechaHoraSalida;
        this.fechaHoraEntregaReal = builder.fechaHoraEntregaReal;
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
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", fechaHoraEntregaReal=" + fechaHoraEntregaReal +
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

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDate getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public LocalDateTime getFechaHoraEntregaReal() {
        return fechaHoraEntregaReal;
    }

    public List<Incidencia> getListaInciencias() {
        return listaInciencias;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaEstimadaEntrega(LocalDate fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setFechaHoraEntregaReal(LocalDateTime fechaHoraEntregaReal) {
        this.fechaHoraEntregaReal = fechaHoraEntregaReal;
    }

    public void setListaInciencias(List<Incidencia> listaInciencias) {
        this.listaInciencias = listaInciencias;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
//================================================================================

    //MEtodos de la Inerfaz

/**
    @Override
    public double CalcularCosto(Tarifa tarifa) {
        return 0;
    }
 **/

    @Override
    public void gestorReportes() {
    }

    @Override
    public void configuracionTarifas() {

    }



    //=============================
    //Patron Builder

    public static class Builder {

        private final String idEnvio;
        private final String estadoEnvio;
        private final LocalDate fechaCreacion;
        private final Direccion direccion;
        private final Tarifa tarifa;

        private LocalDate fechaEstimadaEntrega;
        private LocalDateTime fechaHoraSalida;
        private LocalDateTime fechaHoraEntregaReal;
        private List<Incidencia> listaInciencias;
        private Repartidor repartidor;
        private Usuario usuario;

        public Builder(String idEnvio, String estadoEnvio, LocalDate fechaCreacion, Direccion direccion, Tarifa tarifa) {
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

        public Builder fechaHoraSalida(LocalDateTime fechaHoraSalida) {
            this.fechaHoraSalida = fechaHoraSalida;
            return this;
        }

        public Builder fechaHoraEntregaReal(LocalDateTime fechaHoraEntregaReal) {
            this.fechaHoraEntregaReal = fechaHoraEntregaReal;
            return this;
        }

        public Builder listaInciencias(List<Incidencia> listaInciencias) {
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

    @Override
    public double CalcularCosto(Tarifa tarifa) {
        return tarifa.CalculoTarifa();
    }
}
