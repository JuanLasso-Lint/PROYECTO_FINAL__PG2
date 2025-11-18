package org.uniquindio.edu.co.poo.proyecto_final.model;

public class EnvioDecorador implements IEnvio{

    protected  IEnvio envio;

    public EnvioDecorador(IEnvio envio){
        this.envio = envio;
    }

    @Override
    public double CalcularCosto(Tarifa tarifa) {
        return envio.CalcularCosto(tarifa);
    }

    @Override
    public void gestorReportes() {}

    @Override
    public void configuracionTarifas() {}
}
