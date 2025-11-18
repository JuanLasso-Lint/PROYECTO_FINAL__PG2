package org.uniquindio.edu.co.poo.proyecto_final.model;

public class ReporteViejo {

    private String nombreReporte;
    private String fecha;
    private String contenido;

    public ReporteViejo(String nombreReporte, String fecha, String contenido) {
        this.nombreReporte = nombreReporte;
        this.fecha = fecha;
        this.contenido = contenido;
    }


    public void generar() {
        System.out.println("=== Reporte Viejo ===");
        System.out.println("Nombre: " + nombreReporte);
        System.out.println("Fecha: " + fecha);
        System.out.println("Contenido: " + contenido);
    }


    public void imprimir() {
        System.out.println("Imprimiendo reporte  en formato antiguo");
    }


    public String getNombreReporte() {
        return nombreReporte;
    }

    public String getFecha() {
        return fecha;
    }

    public String getContenido() {
        return contenido;
    }

    // SETTERS
    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}