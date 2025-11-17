package org.uniquindio.edu.co.poo.proyecto_final.model;

public class Usuario extends Persona {

    private String email;
    private String contraseña;
    private String idUsuario;

    public Usuario(String nombre, String identificacion, String telefono, String email,String contraseña, String idUsuario) {
        super(nombre, identificacion, telefono);
        this.email = email;
        this.contraseña = contraseña;
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




    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }
}
