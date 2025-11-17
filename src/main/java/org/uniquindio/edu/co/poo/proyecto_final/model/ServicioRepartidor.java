package org.uniquindio.edu.co.poo.proyecto_final.model;
import java.util.List;
import java.util.Optional;

public class ServicioRepartidor {

    private List<Repartidor> listaRepartidores;

    public ServicioRepartidor(List<Repartidor> listaRepartidores) {
        this.listaRepartidores = listaRepartidores;
    }

    //Metodp interno de buscar
    private Optional<Repartidor> buscarRepartidor(String idRepartidor) {
        return listaRepartidores.stream()
                .filter(r -> r.getIdRepartidor().equals(idRepartidor))
                .findFirst();
    }

    // CRUD

    // Registrar repartidor
    public Optional<Repartidor> registrarRepartidor(Repartidor repartidor) {

        Optional<Repartidor> existente = buscarRepartidor(repartidor.getIdRepartidor());

        if (existente.isPresent()) {
            return Optional.empty(); // No se registró
        }

        listaRepartidores.add(repartidor);
        return Optional.of(repartidor);
    }

    // Editar disponibilidad
    public boolean editarRepartidor(String idRepartidor, EstadoRepartidor nuevaDisponibilidad) {

        Optional<Repartidor> optionalRepartidor = buscarRepartidor(idRepartidor);

        if (optionalRepartidor.isEmpty()) {
            return false;
        }

        Repartidor r = optionalRepartidor.get();
        r.setEstadoDisponibilidad(nuevaDisponibilidad);
        return true;
    }
    // Eliminar repartidor
    public boolean eliminarRepartidor(String idRepartidor) {

        Optional<Repartidor> optionalRepartidor = buscarRepartidor(idRepartidor);

        if (optionalRepartidor.isEmpty()) {
            return false;
        }

        return listaRepartidores.remove(optionalRepartidor.get());
    }

    // Mostrar repartidor
    public Optional<Repartidor> mostrarRepartidor(String idRepartidor) {
        return buscarRepartidor(idRepartidor);
    }

    // Listar repartidores
    public List<Repartidor> getListarRepartidores() {
        return listaRepartidores;
    }
}

