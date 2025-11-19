package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PaginaUsuarioViewController {

    @FXML
    private void GestionCliente(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/GestionUsuario.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void regresarInicio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Tarifa(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/TarifaView.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void MenuEnvio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/MenuEnvioUsuario.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void GestiondIRECCION(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/GestorDirecciones.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();


    }

    @FXML
    private void BuscarEnvio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/ConsultarEnvio.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }


    @FXML
    private void GenerarReporte(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/ReportePDF.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }


}
