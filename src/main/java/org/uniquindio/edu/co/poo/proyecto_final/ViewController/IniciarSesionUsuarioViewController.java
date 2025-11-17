package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.Plataforma;

import java.io.IOException;

public class IniciarSesionUsuarioViewController {

    @FXML
    private TextField idusuario;

    @FXML
    private TextField id;

    Plataforma plataforma = Plataforma.getInstance();

    @FXML
    private void LogearUsuario(ActionEvent event) throws IOException {

        boolean valido = plataforma.LogearUsuario(idusuario.getText(), id.getText());

        if (valido == true){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/ProcesoCorrecto.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } else {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/DatosIncorrectos.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        }

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
