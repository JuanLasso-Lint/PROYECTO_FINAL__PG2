package org.uniquindio.edu.co.poo.proyecto_final.model;

public class EnvioPrioridad extends EnvioDecorador {
    public EnvioPrioridad(IEnvio envio) {
        super(envio);
    }

    @Override
    public double CalcularCosto(Tarifa tarifa) {
        double base = envio.CalcularCosto(tarifa);
        return base + 10000;
    }
}
