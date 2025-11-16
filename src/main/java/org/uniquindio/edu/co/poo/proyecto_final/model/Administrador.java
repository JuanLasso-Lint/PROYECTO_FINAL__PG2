package org.uniquindio.edu.co.poo.proyecto_final.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Administrador extends Persona{

    private String idAdministrador;
    private List<Usuario> listaDeUsuarios;
    private List<Repartidor> listaDeRepartidores;



    public Administrador(String nombre, String identificacion, String telefono) {
        super(nombre, identificacion, telefono);
        this.idAdministrador = identificacion;
        this.listaDeUsuarios = new ArrayList<>();
        this.listaDeRepartidores = new ArrayList<>();
    }


    public String getIdAdministrador() {
        return idAdministrador;
    }
    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }
    public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }







//Se crea la logica de registro (Crud) de clientes (Usuarios con Optional)

    private Optional<Usuario> buscarUsuario(String idUsuario){
        return listaDeUsuarios.stream().filter(u -> u.getIdUsuario().equals(idUsuario)).findFirst();
    }
    public Optional<Usuario> registrarUsuario (Usuario usuario) {

        Optional<Usuario> optionalUsuario = buscarUsuario(usuario.getIdUsuario());
        if (optionalUsuario.isPresent()) {
            System.out.println("El Usuario ya existe\n");
        }else{
            listaDeUsuarios.add(usuario);
            System.out.println("Usuario registrardo");
        }
        return optionalUsuario;
    }
    public String editarVehiculo(String idUsuario, String nuevoEmail) {
        String mensaje = "";
        Optional<Usuario> optionalUsuario = buscarUsuario(idUsuario);

        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();
            usuarioExistente.setEmail(nuevoEmail);
            mensaje += "El Usuario fue actualizado correctamente.\n";
        } else {
            mensaje += "El Usuario no existe.\n";
        }

        return mensaje;
    }
    public String eliminarUsuario (String idUsuario) {
        String mensaje = "";
        Optional<Usuario> optionalUsuario = buscarUsuario(idUsuario);
        if (optionalUsuario.isPresent()) {
            listaDeUsuarios.remove(optionalUsuario.get());
            mensaje += "El Usuario eliminado";
        }else{
            mensaje += "El Usuario no existe\n";
        }
        return mensaje;
    }
    //Este metodo busca el usuario en la lista de usuarios a traves de su id y lo mustra si existe
    public Usuario mostrarUsuario (String idUsuario) {
        Optional<Usuario> optionalUsuario = buscarUsuario(idUsuario);
        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }else {
            System.out.println("El Usuario no existe");
        }
        return null;
    }



    /// Se crea la logica de registro para los repartidores
    private Optional<Repartidor> buscarRepartidor(String idRepartidor){
        return listaDeRepartidores.stream().filter(r -> r.getIdRepartidor().equals(idRepartidor)).findFirst();
    }
    public Optional<Repartidor> registrarRepartidor(Repartidor repartidor) {

        Optional<Repartidor> optionalRepartidor = buscarRepartidor(repartidor.getIdRepartidor());
        if (optionalRepartidor.isPresent()) {
            System.out.println("El repartidor ya existe");
        } else {
            listaDeRepartidores.add(repartidor);
            System.out.println("Repartidor registrado");
        }
        return optionalRepartidor;
    }
    public String editarRepartidor(String idRepartidor, EstadoRepartidor disponibilidad) {
        String mensaje = "";
        Optional<Repartidor> optionalRepartidor = buscarRepartidor(idRepartidor);

        if (optionalRepartidor.isPresent()) {
            Repartidor repartidorExistente = optionalRepartidor.get();
            repartidorExistente.setEstadoDisponibilidad(disponibilidad);
            mensaje += "El repartidor fue actualizado correctamente";
        } else {
            mensaje += "El repartidor no existe";
        }

        return mensaje;
    }
    public String eliminarRepartidor(String idRepartidor) {
        String mensaje = "";
        Optional<Repartidor> optionalRepartidor = buscarRepartidor(idRepartidor);

        if (optionalRepartidor.isPresent()) {
            listaDeRepartidores.remove(optionalRepartidor.get());
            mensaje += "Repartidor eliminado";
        } else {
            mensaje += "El repartidor no existe";
        }

        return mensaje;
    }
    public Repartidor mostrarRepartidor(String idRepartidor) {
        Optional<Repartidor> optionalRepartidor = buscarRepartidor(idRepartidor);

        if (optionalRepartidor.isPresent()) {
            return optionalRepartidor.get();
        } else {
            System.out.println("El repartidor no existe");
            return null;
        }
    }


    //metodo para asignar un envio al repartidor
    public boolean asignarRepartidor(Repartidor repartidor, EnvioBuilder envio, String estadoEnvio, Plataforma plataforma) {

        EnvioBuilder envioAsignado = plataforma.buscarEnvio(envio.getIdEnvio());
        Optional<Repartidor> rep = buscarRepartidor(repartidor.getIdRepartidor());

        if (envioAsignado == null) {
            System.out.println("Envio no encontrado");
            return false;
        }
        if (rep.isEmpty()) {
            System.out.println("Repartidor no encontrado");
            return false;
        }

        EstadoRepartidor estadoRep = repartidor.getEstadoDisponibilidad();
        if (estadoRep == EstadoRepartidor.DESCANSANDO ||
                estadoRep == EstadoRepartidor.EN_RUTA ||
                estadoRep == EstadoRepartidor.INACTIVO) {

            System.out.println("Repartidor no disponible");
            return false;
        }

        if (envioAsignado.getRepartidor() != null) {
            System.out.println("Envio ya asignado");
            return false;
        }

        envioAsignado.setRepartidor(repartidor);
        envioAsignado.setEstadoEnvio(estadoEnvio);
        repartidor.agregarListaEnviosDelRepartidor(envioAsignado);


        return true;
    }














}
