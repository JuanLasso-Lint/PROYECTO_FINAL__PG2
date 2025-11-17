package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.Plataforma;

import java.io.IOException;

public class GestionUsuarioViewController {

    @FXML
    private TextField identificacionN;

    @FXML
    private TextField telefonoN;

    @FXML
    private TextField nombreN;

    @FXML
    private TextField correoN;

    @FXML
    private TextField idbuscar;

    Plataforma plataforma = Plataforma.getInstance();

    @FXML
    private void modificarUsuario(ActionEvent event) throws IOException {
        plataforma.gestionUsuario(nombreN.getText(), identificacionN.getText(), telefonoN.getText(), correoN.getText(), idbuscar.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/ProcesoCorrecto.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void regresarInicio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PaginaUsuario.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

}
