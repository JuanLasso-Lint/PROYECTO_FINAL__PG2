package org.uniquindio.edu.co.poo.proyecto_final.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    private static final Logger LOG = Logger.getLogger(AdministradorTest.class.getName());

    Administrador administrador = new Administrador("001","Juan","1089","3111512");
    Repartidor repartidor1 = new Repartidor("Raul","1353","2312316","16165",EstadoRepartidor.DISPONIBLE,"norte");
    Repartidor repartidor2 = new Repartidor("Ana", "2467", "9876543", "22334", EstadoRepartidor.EN_RUTA, "sur");
    Repartidor repartidor3 = new Repartidor("Luis", "3578", "1239876", "55678", EstadoRepartidor.DESCANSANDO, "centro");



    Usuario usuario1 = new Usuario("Franco", "1165","1456","hdhaaekcam","22522");
    Usuario usuario2 = new Usuario("María", "2233", "778899", "abc123xyz", "33445");
    Usuario usuario3 = new Usuario("Pedro", "3344", "112233", "xyz789abc", "55667");


    Direccion direccion1 = new Direccion("005","dfae","Caller22","Armernia","24s8da");
    Direccion direccion2 = new Direccion("006", "ghjk", "Calle 33", "Bogotá", "8765df");
    Direccion direccion3 = new Direccion("007", "lmno", "Calle 44", "Medellín", "4321gh");


    Tarifa tarifa1 = new Tarifa(22.5, 287.5, TipoProridad.ALTA, 4500, TipoDistancia.CERCA);
    Tarifa tarifa2 = new Tarifa(45.2, 320.1, TipoProridad.BAJA, 8000, TipoDistancia.LEJANA);
    Tarifa tarifa3 = new Tarifa(85.4, 400.0, TipoProridad.MEDIA, 2500, TipoDistancia.LEJANA);


    // Envío con solo los atributos obligatorios
    EnvioBuilder envio1 = new EnvioBuilder.Builder("E001", "Creado", LocalDate.now(), direccion1, tarifa1)
            .build();

    // Envío con repartidor y usuario asignados
    EnvioBuilder envio2 = new EnvioBuilder.Builder("E002", "En camino", LocalDate.now(), direccion2, tarifa2)
            .repartidor(repartidor1)
            .usuario(usuario1)
            .fechaHoraSalida(LocalDateTime.now())
            .build();

    // Envío con repartidor, usuario, fechas completas y lista de incidencias
    EnvioBuilder envio3 = new EnvioBuilder.Builder("E003", "Entregado", LocalDate.now().minusDays(5), direccion3, tarifa3)
            .repartidor(repartidor2)
            .usuario(usuario2)
            .fechaEstimadaEntrega(LocalDate.now().minusDays(2))
            .fechaHoraSalida(LocalDateTime.now().minusDays(4))
            .fechaHoraEntregaReal(LocalDateTime.now().minusDays(2))
            .listaInciencias(List.of(new Incidencia("001",LocalDate.now(),"Se daño", Tipo.DAÑO, EstadoIncidencia.ABIERTA)))
            .build();

    @Test
    public void testRegistroRepartidor() {
        LOG.info("Registro Repartidor, inicio prueba");

        administrador.registrarRepartidor(repartidor1);
        System.out.println(administrador.getListaDeRepartidores());
        Repartidor esperado = new Repartidor("Raul","1353","2312316","16165",EstadoRepartidor.DISPONIBLE,"norte");
        Repartidor actual = administrador.mostrarRepartidor("1353");
        assertEquals(esperado,actual);


        LOG.info("Registro Repartidor, fin prueba");



    }







}

  
