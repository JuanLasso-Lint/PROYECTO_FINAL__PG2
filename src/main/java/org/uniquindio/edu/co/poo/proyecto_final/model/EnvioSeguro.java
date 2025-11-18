package org.uniquindio.edu.co.poo.proyecto_final.model;

public class EnvioSeguro extends EnvioDecorador {

    public EnvioSeguro(IEnvio envio) {
        super(envio);
    }

    @Override
    public double CalcularCosto(Tarifa tarifa) {
        double base = envio.CalcularCosto(tarifa);
        return base * 1.1;  // +10% por seguro
    }
}
