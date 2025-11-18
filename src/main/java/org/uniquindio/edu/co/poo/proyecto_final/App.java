package org.uniquindio.edu.co.poo.proyecto_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.Plataforma;
import org.uniquindio.edu.co.poo.proyecto_final.model.PlataformaFacade;

public class App extends Application {

    public static Plataforma plataforma;
    public static PlataformaFacade fachada;

    @Override
    public void start(Stage primaryStage) throws Exception {



        // Crear la plataforma (SE CREA AQUÍ)
        plataforma = Plataforma.getInstance();

        // Crear la fachada (SOLO UNA)
        fachada = PlataformaFacade.getInstancia();

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


    public static void main(String[] args) {
        launch(args);
    }
}