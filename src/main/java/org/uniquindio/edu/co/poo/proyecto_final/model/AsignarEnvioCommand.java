package org.uniquindio.edu.co.poo.proyecto_final.model;

import org.uniquindio.edu.co.poo.proyecto_final.model.ServicioEnvio;

public class AsignarEnvioCommand implements Command {

    private ServicioEnvio servicioEnvio;
    private String idEnvio;
    private String idRepartidor;

    public AsignarEnvioCommand(ServicioEnvio servicioEnvio, String idEnvio, String idRepartidor) {
        this.servicioEnvio = servicioEnvio;
        this.idEnvio = idEnvio;
        this.idRepartidor = idRepartidor;
    }

    @Override
    public void execute() {
        servicioEnvio.asignarRepartidor(idEnvio, idRepartidor, "ASIGNADO");
    }
}
