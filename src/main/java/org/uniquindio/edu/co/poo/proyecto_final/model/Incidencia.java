package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.time.LocalDate;

public class Incidencia {
    private String idIncidencia;
    private LocalDate fechaIncidencia;
    private String descripcion;
    private Tipo tipo;
    private EstadoIncidencia estado;

    public Incidencia(String idIncidencia, LocalDate fechaIncidencia, String descripcion, Tipo tipo, EstadoIncidencia estado) {
        this.idIncidencia = idIncidencia;
        this.fechaIncidencia = fechaIncidencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(String idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public LocalDate getFechaIncidencia() {
        return fechaIncidencia;
    }

    public void setFechaIncidencia(LocalDate fechaIncidencia) {
        this.fechaIncidencia = fechaIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
    }
}
