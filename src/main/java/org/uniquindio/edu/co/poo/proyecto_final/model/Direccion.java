package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;

public class Direccion {

    private String idDireccion;
    private String alias;
    private String calle;
    private String ciudad;
    private String coordenadas;
    private static ArrayList<Direccion> listaDirecciones = new ArrayList<>();


    public Direccion(String idDireccion) {
        this.idDireccion = idDireccion;
        this.alias = alias;
        this.calle = calle;
        this.ciudad = ciudad;
        this.coordenadas = coordenadas;
    }

    public void TodasListaDirecciones(Direccion direccion) {
        listaDirecciones.add(direccion);
    }

    /**
    public static Direccion crearDireccion(String idDireccion, String alias, String calle, String ciudad, String coordenadas) {
        Direccion nueva = new Direccion(idDireccion);
        nueva.idDireccion = idDireccion;
        nueva.alias = alias;
        nueva.calle = calle;
        nueva.ciudad = ciudad;
        nueva.coordenadas = coordenadas;
        listaDirecciones.add(nueva);
        return nueva;
    }

    public static void actualizarDireccion(Direccion direccion, String alias, String calle, String ciudad, String coordenadas) {
        direccion.setAlias(alias);
        direccion.setCalle(calle);
        direccion.setCiudad(ciudad);
        direccion.setCordenadas(coordenadas);
    }

    public static boolean eliminarDireccion(ArrayList<Direccion> lista, String idDireccion) {
        for (int i = 0; i < lista.size(); i++) {
            Direccion d = lista.get(i);

            if (d.getIdDireccion().equals(idDireccion)) {
                lista.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void mostrarDetallesDireccion(ArrayList<Direccion> lista, String idDireccion) {
        for (Direccion d : lista) {
            if (d.getIdDireccion().equals(idDireccion)) {
                System.out.println("ID: " + d.getIdDireccion());
                System.out.println("Alias: " + d.getAlias());
                System.out.println("Calle: " + d.getCalle());
                System.out.println("Ciudad: " + d.getCiudad());
                System.out.println("Coordenadas: " + d.getCordenadas());
                return;
            }
        }
        System.out.println("No se encontró una dirección con ese ID.");
    }
**/



    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCordenadas() {
        return coordenadas;
    }

    public void setCordenadas(String cordenadas) {
        this.coordenadas = coordenadas;
    }
}
