package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class DatosIncorrectosViewController {

    @FXML
    private Button Regresar;

    @FXML
    private void regresarInicio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org.uniquindio.edu.co.poo.proyecto_final/PantallaInicio.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }
}
