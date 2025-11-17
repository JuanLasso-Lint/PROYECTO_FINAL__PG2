package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Administrador extends Persona{

    private String idAdministrador;


    public Administrador(String idAdministrador,String nombre, String identificacion, String telefono) {
        super(nombre, identificacion, telefono);
        this.idAdministrador = identificacion;


    }
    public String getIdAdministrador() {
        return idAdministrador;
    }
    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }


}
