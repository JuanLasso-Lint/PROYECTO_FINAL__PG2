package org.uniquindio.edu.co.poo.proyecto_final.model;

public interface Subject {
    void agregarObservador(Observer o);
    void removerObservador(Observer o);
    void notificarObservadores(String mensaje);
}