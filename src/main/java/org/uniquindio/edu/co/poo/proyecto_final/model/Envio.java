package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;
import java.util.List;

public class Envio implements Subject {

    public enum EstadoEnvio {
        SOLICITADO,
        EN_RUTA,
        ENTREGADO
    }

    private EstadoEnvio estado;
    private List<Observer> observadores;

    public Envio() {
        this.estado = EstadoEnvio.SOLICITADO;
        this.observadores = new ArrayList<>();
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores("El estado del envío ha cambiado a: " + nuevoEstado);
    }

    @Override
    public void agregarObservador(Observer o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for (Observer o : observadores) {
            o.actualizar(mensaje);
        }
    }
}
