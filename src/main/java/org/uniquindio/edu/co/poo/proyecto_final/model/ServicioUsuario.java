package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.List;
import java.util.Optional;

public class ServicioUsuario {

    private List<Usuario> listaDeUsuarios;

    public ServicioUsuario(List<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }


    //Mtodo interno de buscar
    private Optional<Usuario> buscarUsuario(String idUsuario) {
        return listaDeUsuarios
                .stream()
                .filter(u -> u.getIdUsuario().equals(idUsuario))
                .findFirst();
    }


    // CRUD


    // Registrar usuario
    public Optional<Usuario> registrarUsuario(Usuario usuario) {

        Optional<Usuario> existente = buscarUsuario(usuario.getIdUsuario());

        if (existente.isPresent()) {
            System.out.println("El usuario ya existe");
            return Optional.empty(); // NO se registró
        }

        listaDeUsuarios.add(usuario);
        System.out.println("Usuario registrado correctamente");

        return Optional.of(usuario);
    }
    // Editar email (puedes agregar más parámetros según el caso)
    public String editarUsuario(String idUsuario, String nuevoEmail) {

        Optional<Usuario> optionalUsuario = buscarUsuario(idUsuario);

        if (optionalUsuario.isEmpty()) {
            return "El usuario no existe.";
        }

        Usuario usuario = optionalUsuario.get();
        usuario.setEmail(nuevoEmail);

        return "Usuario actualizado correctamente.";
    }
    // Eliminar usuario
    public String eliminarUsuario(String idUsuario) {

        Optional<Usuario> optionalUsuario = buscarUsuario(idUsuario);

        if (optionalUsuario.isEmpty()) {
            return "El usuario no existe.";
        }

        listaDeUsuarios.remove(optionalUsuario.get());
        return "Usuario eliminado correctamente.";
    }
    // Mostrar un Usuario
    public Optional<Usuario> mostrarUsuario(String idUsuario) {
        return buscarUsuario(idUsuario);
    }
    // Listar usuarios
    public List<Usuario> getListarUsuarios() {
        return listaDeUsuarios;
    }




}





