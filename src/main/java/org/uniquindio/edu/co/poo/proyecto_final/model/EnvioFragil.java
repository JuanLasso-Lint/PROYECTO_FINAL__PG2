package org.uniquindio.edu.co.poo.proyecto_final.model;

public class EnvioFragil extends EnvioDecorador {


    public EnvioFragil(IEnvio envio) {
        super(envio);
    }

    @Override
    public double CalcularCosto(Tarifa tarifa) {
        double base = envio.CalcularCosto(tarifa);
        return base + 5000;
    }

}
