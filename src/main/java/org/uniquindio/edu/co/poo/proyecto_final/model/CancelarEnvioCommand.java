package org.uniquindio.edu.co.poo.proyecto_final.model;

import org.uniquindio.edu.co.poo.proyecto_final.model.ServicioEnvio;

public class CancelarEnvioCommand implements Command {

    private ServicioEnvio servicioEnvio;
    private String idEnvio;

    public CancelarEnvioCommand(ServicioEnvio servicioEnvio, String idEnvio) {
        this.servicioEnvio = servicioEnvio;
        this.idEnvio = idEnvio;
    }

    @Override
    public void execute() {
        servicioEnvio.editarEstado(idEnvio, "CANCELADO");
    }
}

