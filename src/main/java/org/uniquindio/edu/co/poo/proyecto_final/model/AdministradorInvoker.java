package org.uniquindio.edu.co.poo.proyecto_final.model;


public class AdministradorInvoker {

    public void ejecutar(Command command) {
        command.execute();
    }
}

