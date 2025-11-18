package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TarifaViewController implements Initializable {

    @FXML
    private ComboBox<String> cbTipoTarifa;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtVolumen;

    @FXML
    private ComboBox<TipoPrioridad> cbPrioridad;

    @FXML
    private ComboBox<TipoDistancia> cbDistancia;

    @FXML
    private TextField txtRecargo;

    @FXML
    private Label lblResultado;

    @FXML
    private Button Regresar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Llenado CORRECTO de ComboBox (ya funciona porque fx:id es correcto)
        cbTipoTarifa.getItems().addAll("ESTÁNDAR", "EXPRESS", "INTERNACIONAL");
        cbPrioridad.getItems().addAll(TipoPrioridad.values());
        cbDistancia.getItems().addAll(TipoDistancia.values());
    }

    @FXML
    private void regresarInicio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml")
        );

        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void calcularTarifa() {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double volumen = Double.parseDouble(txtVolumen.getText());
            double recargo = Double.parseDouble(txtRecargo.getText());
            TipoPrioridad prioridad = cbPrioridad.getValue();
            TipoDistancia distancia = cbDistancia.getValue();
            String tipo = cbTipoTarifa.getValue();

            CalculoTarifaStrategy estrategia = switch (tipo) {
                case "EXPRESS" -> new TarifaExpress();
                case "INTERNACIONAL" -> new TarifaInternacional();
                default -> new TarifaEstandar();
            };

            Tarifa tarifa = new Tarifa(peso, volumen, prioridad, recargo, distancia);

            double resultado = estrategia.calcular(tarifa);

            lblResultado.setText("Total: $" + resultado);

        } catch (Exception ex) {
            lblResultado.setText("Error: verifica los datos ingresados");
        }
    }
}
