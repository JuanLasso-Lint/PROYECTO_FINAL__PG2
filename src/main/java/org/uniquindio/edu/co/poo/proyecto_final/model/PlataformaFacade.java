package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.List;
import java.util.Optional;

public class PlataformaFacade {

    private static PlataformaFacade instancia;


    private Plataforma plataforma;

    private  ServicioUsuario servicioUsuario;
    private  ServicioRepartidor servicioRepartidor;
    private  ServicioEnvio servicioEnvio;
    private  ServicioDirecciones servicioDireccion;
    private  ServicioMetricas servicioMetricas;

    public PlataformaFacade() {

        // Obtener única instancia del sistema
        this.plataforma = Plataforma.getInstance();

        // Servicios conectados a la base de datos en memoria (Plataforma)
        this.servicioUsuario = new ServicioUsuario(plataforma.getListaUsuarios());
        this.servicioRepartidor = new ServicioRepartidor(plataforma.getListaRepartidores());
        this.servicioEnvio = new ServicioEnvio(plataforma.getListaEnvios(), plataforma.getListaRepartidores());
        this.servicioDireccion = new ServicioDirecciones(servicioUsuario);
        this.servicioMetricas = new ServicioMetricas();
    }

    public static PlataformaFacade getInstancia() {
        if (instancia == null) {
            instancia = new PlataformaFacade();
        }
        return instancia;
    }

    // ======================================================
    // USUARIOS
    // ======================================================

    public boolean registrarUsuario(Usuario usuario) {
        return servicioUsuario.registrarUsuario(usuario).isEmpty();
    }

    public String editarUsuario(String idUsuario, String nuevoEmail) {
        return servicioUsuario.editarUsuario(idUsuario, nuevoEmail);
    }

    public String eliminarUsuario(String idUsuario) {
        return servicioUsuario.eliminarUsuario(idUsuario);
    }

    public Optional<Usuario> mostrarUsuario(String idUsuario) {
        return servicioUsuario.mostrarUsuario(idUsuario);
    }

    public List<Usuario> listarUsuarios() {
        return servicioUsuario.getListarUsuarios();
    }

    // ======================================================
    // DIRECCIONES
    // ======================================================

    public boolean agregarDireccion(String idUsuario, Direccion direccion) {
        return servicioDireccion.agregarDireccion(idUsuario, direccion);
    }

   // public boolean editarDireccion(String idUsuario, int index, Direccion direccion) {
    //    return servicioDireccion.editarDirecciones(idUsuario, index, direccion);
    //}

    public boolean eliminarDireccion(String idUsuario, String idDireccion) {
        return servicioDireccion.eliminarDireccion(idUsuario, idDireccion);
    }

    public List<Direccion> listarDirecciones(String idUsuario) {
        return servicioDireccion.listarDirecciones(idUsuario);
    }

    // ======================================================
    // REPARTIDORES
    // ======================================================

    public boolean registrarRepartidor(Repartidor repartidor) {
        return servicioRepartidor.registrarRepartidor(repartidor).isEmpty();
    }

    public boolean editarRepartidor(String id, EstadoRepartidor estado) {
        return servicioRepartidor.editarRepartidor(id, estado);
    }

    public boolean eliminarRepartidor(String idRepartidor) {
        return servicioRepartidor.eliminarRepartidor(idRepartidor);
    }

    public Optional<Repartidor> mostrarRepartidor(String idRepartidor) {
        return servicioRepartidor.mostrarRepartidor(idRepartidor);
    }

    public java.util.List<Repartidor> listarRepartidores() {
        return plataforma.getListaRepartidores();
    }

    // ======================================================
    // ENVIOS
    // ======================================================

    public boolean registrarEnvio(EnvioBuilder envio) {
        return servicioEnvio.registrarEnvio(envio).isEmpty();
    }

    public boolean asignarRepartidorAEnvio(String idRepartidor, String idEnvio, String nuevoEstado) {
        return servicioEnvio.asignarRepartidor(idRepartidor, idEnvio, nuevoEstado);
    }

    public Optional<EnvioBuilder> mostrarEnvio(String idEnvio) {
        return servicioEnvio.mostrarEnvio(idEnvio);
    }

    public List<EnvioBuilder> listarEnvios() {
        return plataforma.getListaEnvios();
    }

    // ======================================================
    // MÉTRICAS
    // ======================================================
/**
    public double tiempoPromedioEntrega() {
        return servicioMetricas.tiempoPromedioEntrega(plataforma);
    }
**/


}
