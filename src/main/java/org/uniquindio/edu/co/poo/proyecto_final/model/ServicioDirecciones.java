package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.List;
import java.util.Optional;

/**
 * Gestiona las direcciones asociadas a un usuario.
 * Solo permite agregar o eliminar direcciones si el usuario existe.
 * No crea direcciones sin dueño y no mantiene una lista global.
 */
public class ServicioDirecciones {

    private final ServicioUsuario servicioUsuario;

    /**
     * Constructor del servicio.
     * @param servicioUsuario servicio usado para validar y obtener usuarios.
     */
    public ServicioDirecciones(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    /**
     * Agrega una dirección a un usuario existente.

     */
    public boolean agregarDireccion(String idUsuario, Direccion direccion) {

        Optional<Usuario> usuario = servicioUsuario.mostrarUsuario(idUsuario);
        if (usuario.isEmpty()) {
            System.out.println("El usuario no existe");
            return false;
        }

        usuario.get().agregarDireccion(direccion);
        return true;
    }

    /**
     * Elimina una dirección de un usuario existente.
     */
    public boolean eliminarDireccion(String idUsuario, String idDireccion) {

        Optional<Usuario> opt = servicioUsuario.mostrarUsuario(idUsuario);
        if (opt.isEmpty()) {
            return false;
        }

        Usuario usuario = opt.get();
        usuario.eliminarDireccion(idDireccion);
        return true;
    }




    /**
     * Devuelve la lista de direcciones de un usuario.
     */
    public List<Direccion> listarDirecciones(String idUsuario) {

        Optional<Usuario> usuario = servicioUsuario.mostrarUsuario(idUsuario);
        if (usuario.isEmpty()) {
            System.out.println("El usuario no existe");
            return List.of();
        }
        return usuario.get().getDirecciones();
    }

    //s
}

