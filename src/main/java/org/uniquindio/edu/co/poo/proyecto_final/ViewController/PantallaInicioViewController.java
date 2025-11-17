package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaInicioViewController {

    @FXML
    private void LogearUsuario(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/OpcionesUsuario.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

}
