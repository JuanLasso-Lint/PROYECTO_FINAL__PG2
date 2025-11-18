package org.uniquindio.edu.co.poo.proyecto_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.Direccion;
import org.uniquindio.edu.co.poo.proyecto_final.model.Plataforma;
import org.uniquindio.edu.co.poo.proyecto_final.model.PlataformaFacade;
import org.uniquindio.edu.co.poo.proyecto_final.model.Usuario;

public class App extends Application {

    public static Plataforma plataforma;
    public static PlataformaFacade fachada;

    Usuario usuario = new Usuario("1","1","1","1","1");
    Direccion direccion = new Direccion("51","51","51","51","51");


    @Override
    public void start(Stage primaryStage) throws Exception {



        // Crear la plataforma (SE CREA AQUÍ)
        plataforma = Plataforma.getInstance();

        // Crear la fachada (SOLO UNA)
        fachada = PlataformaFacade.getInstancia();
        fachada.registrarUsuario(usuario);
        fachada.agregarDireccion("1", direccion);

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