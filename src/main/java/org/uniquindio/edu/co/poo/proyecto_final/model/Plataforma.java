package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;

public class Plataforma {

    private String nombre;
    private ArrayList<Usuario> listaUsuarios;


    public  Plataforma(String nombre) {
        this.nombre = nombre;
    }

    public String RegistrarUsuario(String nombre, String identificacion, String telefono, String email, String idUsuario) {

        String mensaje = "";

        if (identificacion.equals(listaUsuarios.get(0).getIdentificacion())) {
            mensaje = "El usuario ya esta registrado";
        }

        String nombreAregistrar =  nombre;
        String identificacionAregistrar = identificacion;
        String telefonoAregistrar = telefono;
        String emailAregistrar = email;
        String idUsuarioAregistrar = idUsuario;

        return mensaje;

    }
}
