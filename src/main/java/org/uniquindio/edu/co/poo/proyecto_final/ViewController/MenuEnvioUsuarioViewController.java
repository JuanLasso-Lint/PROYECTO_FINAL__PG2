package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuEnvioUsuarioViewController {

    @FXML
    private void CrearEnvio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/CrearEnvio.fxml"));

        System.out.println(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/CrearEnvio.fxml"));


        Scene scene = new Scene(loader.load());


        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();



    }

    @FXML
    private void ModificarEnvio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void EliminarEnvio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void regresarInicio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/OpcionesUsuario.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

}
