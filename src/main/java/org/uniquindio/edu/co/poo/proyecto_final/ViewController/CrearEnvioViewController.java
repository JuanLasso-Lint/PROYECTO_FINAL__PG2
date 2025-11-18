package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.*;

import java.io.IOException;

public class CrearEnvioViewController {

    @FXML
    private TextField idenvio;
    @FXML private TextField fechaE;
    @FXML private TextField idE;
    @FXML private TextField horaE;
    @FXML private TextField direccionE;
    @FXML private TextField pesoE;
    @FXML private TextField volumenE;

    @FXML private ComboBox<TipoDistancia> distanciaE;
    @FXML private ComboBox<TipoProridad> prioridadE;
    @FXML private ComboBox<String> servicioA;



    @FXML
    public void initialize() {
        distanciaE.getItems().addAll(TipoDistancia.values());
        prioridadE.getItems().addAll(TipoProridad.values());

        servicioA.getItems().addAll("NINGUNO", "FRAGIL", "PRIORIDAD", "SEGURO");
    }

    @FXML
    public void crearEnvio(ActionEvent event) throws IOException {

        try {
            String idEnvio = idenvio.getText();
            String direccionTxt = direccionE.getText();

            double peso = Double.parseDouble(pesoE.getText());
            double volumen = Double.parseDouble(volumenE.getText());

            TipoDistancia distancia = distanciaE.getValue();
            TipoProridad prioridad = prioridadE.getValue();
            String adicional = servicioA.getValue();

            Tarifa tarifa = new Tarifa(
                    peso,
                    volumen,
                    prioridad,
                    0,
                    distancia
            );

            EnvioBuilder envio = new EnvioBuilder.Builder(
                    idEnvio,
                    "CREADO",
                    java.time.LocalDate.now(),
                    new Direccion(direccionTxt),
                    tarifa
            ).build();

            IEnvio envioFinal = envio;

            switch (adicional) {
                case "FRAGIL" -> envioFinal = new EnvioFragil(envioFinal);
                case "PRIORIDAD" -> envioFinal = new EnvioPrioridad(envioFinal);
                case "SEGURO" -> envioFinal = new EnvioSeguro(envioFinal);
            }

        } catch (Exception e) {
            System.out.println("Error guardando envío: " + e.getMessage());
        }

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
