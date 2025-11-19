package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.List;
import java.util.Optional;

public class ServicioEnvio {

    private List<EnvioBuilder> listaEnvios;
    private List<Repartidor> listaRepartidores;

    public ServicioEnvio(List<EnvioBuilder> listaEnvios, List<Repartidor> listaRepartidores) {
        this.listaEnvios = listaEnvios;
        this.listaRepartidores = listaRepartidores;
    }

    // =========================================================
    // MÉTODOS INTERNOS
    // =========================================================

    private Optional<EnvioBuilder> buscarEnvio(String idEnvio) {
        return listaEnvios.stream()
                .filter(e -> e.getIdEnvio().equals(idEnvio))
                .findFirst();
    }

    private Optional<Repartidor> buscarRepartidor(String idRepartidor) {
        return listaRepartidores.stream()
                .filter(r -> r.getIdRepartidor().equals(idRepartidor))
                .findFirst();
    }

    private boolean repartidorDisponible(Repartidor r) {
        return r.getEstadoDisponibilidad() == EstadoRepartidor.DISPONIBLE;
    }

    public boolean cancelarEnvio(String idEnvio) {
        return editarEstado(idEnvio, "CANCELADO");
    }


    private boolean envioYaAsignado(EnvioBuilder e) {
        return e.getRepartidor() != null;
    }


    // =========================================================
    // CRUD DE ENVIOS
    // =========================================================

    protected Tarifa tarifa;

    public void CrearEnvio (Tarifa tarifa) {

    }

    public Optional<EnvioBuilder> registrarEnvio(EnvioBuilder envio) {
        Optional<EnvioBuilder> opt = buscarEnvio(envio.getIdEnvio());

        if (opt.isPresent()) {
            return Optional.empty();
        }

        listaEnvios.add(envio);
        return Optional.of(envio);
    }


    public boolean eliminarEnvio(String idEnvio) {
        Optional<EnvioBuilder> opt = buscarEnvio(idEnvio);

        if (opt.isEmpty()) return false;

        return listaEnvios.remove(opt.get());
    }


    public boolean editarEstado(String idEnvio, String nuevoEstado) {
        Optional<EnvioBuilder> opt = buscarEnvio(idEnvio);

        if (opt.isEmpty()) return false;

        opt.get().setEstadoEnvio(nuevoEstado);
        return true;
    }


    public Optional<EnvioBuilder> mostrarEnvio(String idEnvio) {
        return buscarEnvio(idEnvio);
    }


    public List<EnvioBuilder> listarEnvios() {
        return listaEnvios;
    }


    // =========================================================
    // ASIGNACIÓN DE REPARTIDOR
    // =========================================================
    public boolean asignarRepartidor(String idEnvio, String idRepartidor, String nuevoEstadoEnvio) {

        System.out.println(" Intentando asignar repartidor...");
        System.out.println("ID Envío: " + idEnvio);
        System.out.println("ID Repartidor: " + idRepartidor);
        System.out.println("Nuevo estado: " + nuevoEstadoEnvio);

        if (idEnvio == null || idEnvio.isBlank() || idRepartidor == null || idRepartidor.isBlank()) {
            System.out.println(" ID de envío o repartidor inválido");
            return false;
        }

        Optional<EnvioBuilder> optEnvio = buscarEnvio(idEnvio);
        Optional<Repartidor> optRep = buscarRepartidor(idRepartidor);

        if (optEnvio.isEmpty()) {
            System.out.println(" Envío no encontrado");
            return false;
        }

        if (optRep.isEmpty()) {
            System.out.println(" Repartidor no encontrado");
            return false;
        }

        EnvioBuilder envio = optEnvio.get();
        Repartidor rep = optRep.get();

        if (!repartidorDisponible(rep)) {
            System.out.println(" Repartidor no disponible");
            return false;
        }

        if (envioYaAsignado(envio)) {
            System.out.println(" Envío ya asignado");
            return false;
        }

        // ASIGNAR
        envio.setRepartidor(rep);
        envio.setEstadoEnvio(nuevoEstadoEnvio);
        rep.agregarListaEnviosDelRepartidor(envio);

        System.out.println(" Asignación exitosa");
        return true;
    }


}

