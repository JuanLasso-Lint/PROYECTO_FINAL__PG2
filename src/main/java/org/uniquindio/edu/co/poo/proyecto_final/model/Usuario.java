package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {

    private String email;
    private String idUsuario;

    private List<Direccion> direcciones;

    public Usuario(String nombre, String identificacion, String telefono, String email, String idUsuario) {
        super(nombre, identificacion, telefono);
        this.email = email;
        this.idUsuario = idUsuario;
        this.direcciones = new ArrayList<Direccion>();
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public List<Direccion> getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", direcciones=" + direcciones +
                '}';
    }

    public void agregarDireccion(Direccion direccion) {
        direcciones.add(direccion);
    }

    public void eliminarDireccion(String idDireccion) {
        direcciones.removeIf(d -> d.getIdDireccion().equals(idDireccion));
    }



}
