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

        Usuario usuario = servicioUsuario.mostrarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println("El usuario no existe");
            return false;
        }

        usuario.agregarDireccion(direccion);
        direccion.TodasListaDirecciones(direccion);
        return true;
    }


    /**
     * Elimina una dirección de un usuario existente.
     */
    public boolean eliminarDireccion(String idUsuario, String idDireccion) {

        Usuario usuario = servicioUsuario.buscarUsuario(idUsuario);

        if (usuario == null) {
            return false;
        }

        usuario.eliminarDireccion(idDireccion);
        return true;
    }





    /**
     * Devuelve la lista de direcciones de un usuario.
     */
    public List<Direccion> listarDirecciones(String idUsuario) {

        Usuario usuario = servicioUsuario.buscarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println("El usuario no existe");
            return List.of();
        }

        return usuario.getDirecciones();
    }


    public boolean editarDireccion(String idUsuario, Direccion nuevosDatos) {

        Usuario usuario = servicioUsuario.buscarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println("El usuario no existe");
            return false;
        }

        for (Direccion d : usuario.getDirecciones()) {
            if (d.getIdDireccion().equals(nuevosDatos.getIdDireccion())) {

                d.setAlias(nuevosDatos.getAlias());
                d.setCalle(nuevosDatos.getCalle());
                d.setCiudad(nuevosDatos.getCiudad());
                d.setCordenadas(nuevosDatos.getCordenadas());

                return true;
            }
        }

        return false;
    }



    //s
}

