package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static org.uniquindio.edu.co.poo.proyecto_final.App.plataforma;

public class InicioSesionAdminViewController {

        @FXML
        private TextField idAdmin;

        @FXML
        private TextField txtId;

        @FXML
        void IRpantallaInicio(ActionEvent event) {

        }



        @FXML
        void IngresarAdmin(ActionEvent event) throws IOException {


            boolean valido = plataforma.LogearAdmin(idAdmin.getText(), txtId.getText());



            if (valido == true){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PaginaAdmin.fxml"));
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





}
