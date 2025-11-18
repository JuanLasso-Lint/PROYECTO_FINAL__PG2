package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.*;

public class TarifaViewController extends Application {

    private ComboBox<String> cbTipoTarifa;
    private TextField txtPeso;
    private TextField txtVolumen;
    private ComboBox<TipoPrioridad> cbPrioridad;
    private ComboBox<TipoDistancia> cbDistancia;
    private TextField txtRecargo;
    private Label lblResultado;

    @Override
    public void start(Stage stage) throws Exception {

        // Cargar FXML (sin controller)
        Parent root = FXMLLoader.load(getClass().getResource("TarifaView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cálculo de Tarifa");
        stage.show();

        // Obtener nodos del FXML
        cbTipoTarifa = (ComboBox<String>) root.lookup("#cbTipoTarifa");
        txtPeso = (TextField) root.lookup("#txtPeso");
        txtVolumen = (TextField) root.lookup("#txtVolumen");
        cbPrioridad = (ComboBox<TipoPrioridad>) root.lookup("#cbPrioridad");
        cbDistancia = (ComboBox<TipoDistancia>) root.lookup("#cbDistancia");
        txtRecargo = (TextField) root.lookup("#txtRecargo");
        lblResultado = (Label) root.lookup("#lblResultado");

        // Llenar ComboBoxes
        cbTipoTarifa.getItems().addAll("ESTÁNDAR", "EXPRESS", "INTERNACIONAL");
        cbPrioridad.getItems().addAll(TipoPrioridad.values());
        cbDistancia.getItems().addAll(TipoDistancia.values());

        // Botón calcular
        root.lookup("#btnCalcular").setOnMouseClicked(e -> calcularTarifa());
    }

    private void calcularTarifa() {
        try {
            // Obtener valores
            double peso = Double.parseDouble(txtPeso.getText());
            double volumen = Double.parseDouble(txtVolumen.getText());
            double recargo = Double.parseDouble(txtRecargo.getText());
            TipoPrioridad prioridad = cbPrioridad.getValue();
            TipoDistancia distancia = cbDistancia.getValue();
            String tipo = cbTipoTarifa.getValue();

            // Aplicar Strategy
            CalculoTarifaStrategy estrategia = switch (tipo) {
                case "EXPRESS" -> new TarifaExpress();
                case "INTERNACIONAL" -> new TarifaInternacional();
                default -> new TarifaEstandar();
            };

            // Crear tarifa
            Tarifa tarifa = new Tarifa(peso, volumen, prioridad, recargo, distancia);

            // Llamar estrategia
            double resultado = estrategia.calcular(tarifa);

            // Mostrar resultado
            lblResultado.setText("Total: $" + resultado);

        } catch (Exception ex) {
            lblResultado.setText("Error: verifica los datos ingresados");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

