package org.uniquindio.edu.co.poo.proyecto_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml"
        ));
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("ProyectoFinal - Inicio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}