package org.uniquindio.edu.co.poo.proyecto_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.*;

import java.time.LocalDate;

public class App extends Application {

    public static Plataforma plataforma;
    public static PlataformaFacade fachada;

    Usuario usuario = new Usuario("1","1","1","1","1");
    Direccion direccion = new Direccion("51","51","51","51","51");
    Administrador administrador = new Administrador("001","Juan","001","001");
    Direccion direccion2 = new Direccion("51","51","51","51","51");
    Tarifa tarifa = new Tarifa();


    // Ejemplo 1
    EnvioBuilder envio1 = new EnvioBuilder.Builder("ENV001", "Creado", LocalDate.now(), direccion2, tarifa).build();

    // Ejemplo 2
    EnvioBuilder envio2 = new EnvioBuilder.Builder(
            "ENV002",
            "Pendiente",
            LocalDate.now(),
            direccion,
            tarifa
    ).build();

    // Ejemplo 3
    EnvioBuilder envio3 = new EnvioBuilder.Builder(
            "ENV003",
            "Enviado",
            LocalDate.now(),
            direccion2,
            tarifa
    ).build();

    Repartidor repartidor = new Repartidor("Juan","005","322","156",EstadoRepartidor.EN_RUTA,"Norte");
    Repartidor repartidor2 = new Repartidor("Jusan","006","322","1506",EstadoRepartidor.DISPONIBLE,"Norte");


    @Override
    public void start(Stage primaryStage) throws Exception {



        // Crear la plataforma (SE CREA AQUÍ)
        plataforma = Plataforma.getInstance();

        // Crear la fachada (SOLO UNA)
        fachada = PlataformaFacade.getInstancia();
        fachada.registrarUsuario(usuario);
        fachada.agregarDireccion("1", direccion);
        plataforma.RegistrarAdmin(administrador);
        fachada.registrarEnvio(envio1);
        fachada.registrarEnvio(envio2);
        fachada.registrarEnvio(envio3);
        fachada.registrarRepartidor(repartidor);
        fachada.registrarRepartidor(repartidor2);



        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml"
        ));
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("ProyectoFinal - Inicio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static PlataformaFacade getFachada() {
        return fachada;
    }

    public static Plataforma getPlataforma() {
        return plataforma;
    }


    public static void main(String[] args) {
        launch(args);
    }
}