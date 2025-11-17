package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;

public class Plataforma {

    private ArrayList<Usuario> listaUsuarios;

    private static Plataforma instance;

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

    public Usuario buscarUsuario(String idUsuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getIdUsuario().equals(idUsuario)) {
                return listaUsuarios.get(i);
            }
        }

        return null;
    }

    public void gestionUsuario(String nombreNuevo, String identificacionNuevo,
                               String telefonoNuevo, String emailNuevo,
                               String idUsuarioBuscar) {

        Usuario u = buscarUsuario(idUsuarioBuscar);

        if (u != null) {
            u.setNombre(nombreNuevo);
            u.setIdentificacion(identificacionNuevo);
            u.setTelefono(telefonoNuevo);
            u.setEmail(emailNuevo);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
}

