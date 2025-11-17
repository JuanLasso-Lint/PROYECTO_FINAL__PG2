package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;

public class Plataforma {

    private ArrayList<Usuario> listaUsuarios;

    public Usuario RegistrarUsuario(String nombre, String identificacion, String telefono, String email, String idUsuario) {

        Usuario usuario = new Usuario(nombre, identificacion, telefono, email, idUsuario);
        listaUsuarios.add(usuario);

        return usuario;

    }
}
