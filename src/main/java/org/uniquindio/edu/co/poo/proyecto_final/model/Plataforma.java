package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {

    private static Plataforma instance;

    private final List<Usuario> listaUsuarios;
    private final List<Repartidor> listaRepartidores;
    private final List<EnvioBuilder> listaEnvios;


    public Plataforma() {
        listaUsuarios = new ArrayList<>();
        listaRepartidores = new ArrayList<>();
        listaEnvios = new ArrayList<>();
    }

    public static Plataforma getInstance() {
        if (instance == null) {
            instance = new Plataforma();
        }
        return instance;
    }

/**
    public Usuario RegistrarUsuario(String nombre, String identificacion, String telefono, String email, String idUsuario) {

        Usuario usuario = new Usuario(nombre, identificacion, telefono, email, idUsuario);
        listaUsuarios.add(usuario);

        return usuario;
    }
**/



//    ===============================
//Logica de incio de sesion
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




    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public List<Repartidor> getListaRepartidores() {
        return listaRepartidores;
    }

    public List<EnvioBuilder> getListaEnvios() {
        return listaEnvios;
    }
}

