package org.uniquindio.edu.co.poo.proyecto_final.model;

public abstract class Persona {

    protected String nombre;
    protected String identificacion;
    protected String telefono;

    public Persona(String nombre, String identificacion, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTelefono() {
        return telefono;
    }




}
