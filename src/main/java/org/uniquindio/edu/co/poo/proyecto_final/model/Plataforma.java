package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;

public class Plataforma {

    private static Plataforma instance;

    private ArrayList<Usuario> listaUsuarios;

    public Plataforma() {
        listaUsuarios = new ArrayList<>();
    }

    public static Plataforma getInstance() {
        if (instance == null) {
            instance = new Plataforma();
        }
        return instance;
    }

    public Usuario RegistrarUsuario(String nombre, String identificacion, String telefono, String email, String idUsuario) {

        Usuario usuario = new Usuario(nombre, identificacion, telefono, email, idUsuario);
        listaUsuarios.add(usuario);

        return usuario;
    }

    public boolean LogearUsuario(String identificacionA, String idUsuarioA) {

        for (Usuario u : listaUsuarios) {
            if (u.getIdentificacion().equals(identificacionA) &&
                    u.getIdUsuario().equals(idUsuarioA)) {
                return true;
            }
        }

        return false;
    }

    public void gestionUsuario(String identificacionCuestion){
        for (Usuario u : listaUsuarios) {
            if (u.getIdentificacion().equals(identificacionCuestion)) {

                String nombre = u.getNombre();
                String identificacion = u.getIdentificacion();
                String telefono = u.getTelefono();
                String email = u.getEmail();
                String idUsuario = u.getIdUsuario();

            }
        }

    }

}
