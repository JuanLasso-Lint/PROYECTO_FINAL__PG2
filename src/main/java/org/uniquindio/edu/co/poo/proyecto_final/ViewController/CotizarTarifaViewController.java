package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.Tarifa;
import org.uniquindio.edu.co.poo.proyecto_final.model.TipoDistancia;
import org.uniquindio.edu.co.poo.proyecto_final.model.TipoProridad;

import java.awt.*;
import java.io.IOException;

public class CotizarTarifaViewController {

    @FXML
    private Label costo;

    @FXML
    private TextField pesoT;

    @FXML
    private TextField recargoT;

    @FXML
    private TextField volumenT;

    @FXML
    private ComboBox<TipoDistancia> distanciaT;

    @FXML
    private ComboBox<TipoProridad> prioridadT;

    @FXML
    public void initialize() {
        distanciaT.getItems().addAll(TipoDistancia.values());
        prioridadT.getItems().addAll(TipoProridad.values());
    }

    @FXML
    public void CalcularCosto(ActionEvent event){

        //Conversion de texto a double

        double peso = Double.parseDouble(pesoT.getText());
        double volumen = Double.parseDouble(volumenT.getText());
        double recargo = Double.parseDouble(recargoT.getText());

        TipoDistancia distanciaSeleccionada = distanciaT.getValue();
        TipoProridad prioridadSeleccionada = prioridadT.getValue();

        Tarifa tarifa = new Tarifa(peso, volumen, prioridadSeleccionada, (int) recargo, distanciaSeleccionada);

        double precio = tarifa.CalculoTarifa(peso, volumen, prioridadSeleccionada, recargo, distanciaSeleccionada);

        costo.setText("Costo: " + precio);

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
