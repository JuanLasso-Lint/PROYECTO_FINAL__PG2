package org.uniquindio.edu.co.poo.proyecto_final.model;

public class Usuario extends Persona {

    private String email;
    private String idUsuario;

    public Usuario(String nombre, String identificacion, String telefono, String email, String idUsuario) {
        super(nombre, identificacion, telefono);
        this.email = email;
        this.idUsuario = idUsuario;
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
}
