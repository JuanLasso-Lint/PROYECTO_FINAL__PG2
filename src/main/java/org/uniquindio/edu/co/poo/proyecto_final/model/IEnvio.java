package org.uniquindio.edu.co.poo.proyecto_final.model;

public interface IEnvio {

    double CalcularCosto(Tarifa tarifa);
    void gestorReportes();
    void configuracionTarifas();
}
