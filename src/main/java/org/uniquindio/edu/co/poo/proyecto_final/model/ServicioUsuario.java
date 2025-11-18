package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.List;
import java.util.Optional;

public class ServicioUsuario {

    private List<Usuario> listaDeUsuarios;

    public ServicioUsuario(List<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }


    //Mtodo interno de buscar
    public Usuario buscarUsuario(String idUsuario) {
        for (Usuario u : listaDeUsuarios) {
            if (u.getIdUsuario().equals(idUsuario)) {
                return u;
            }
        }
        return null;
    }



    // CRUD


    // Registrar usuario
    public Usuario registrarUsuario(Usuario usuario) {

        Usuario existente = buscarUsuario(usuario.getIdUsuario());

        if (existente != null) {
            System.out.println("El usuario ya existe");
            return null;
        }

        listaDeUsuarios.add(usuario);
        System.out.println("Usuario registrado correctamente");

        return usuario;
    }

    //Editar Usuario
    public String editarUsuario(String idUsuario, String nuevoEmail) {

        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            return "El usuario no existe.";
        }

        usuario.setEmail(nuevoEmail);
        return "Usuario actualizado correctamente.";
    }

    //Eliminar Usuario
    public String eliminarUsuario(String idUsuario) {

        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            return "El usuario no existe.";
        }

        listaDeUsuarios.remove(usuario);
        return "Usuario eliminado correctamente.";
    }

    //Mostrar Usuario
    public Usuario mostrarUsuario(String idUsuario) {
        return buscarUsuario(idUsuario);
    }



    // Listar usuarios
    public List<Usuario> getListarUsuarios() {
        return listaDeUsuarios;
    }







}





