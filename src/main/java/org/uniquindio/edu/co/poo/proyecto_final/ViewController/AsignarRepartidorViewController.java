package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.App;
import org.uniquindio.edu.co.poo.proyecto_final.model.EnvioBuilder;
import org.uniquindio.edu.co.poo.proyecto_final.model.PlataformaFacade;
import org.uniquindio.edu.co.poo.proyecto_final.model.Repartidor;

import java.io.IOException;

public class AsignarRepartidorViewController {

    @FXML
    private ComboBox<String> ComboxRepartidor;

    @FXML
    private ComboBox<String> comboxEnvio;

    @FXML
    private TextField txtEstadoEnvio;

    private final PlataformaFacade fachada = App.getFachada();

    @FXML
    public void initialize() {
        // Poblar ComboBox con IDs desde la fachada
        ComboxRepartidor.getItems().addAll(
                fachada.listarRepartidores().stream()
                        .map(Repartidor::getIdRepartidor)
                        .toList()
        );

        comboxEnvio.getItems().addAll(
                fachada.listarEnvios().stream()
                        .map(EnvioBuilder::getIdEnvio)
                        .toList()
        );
    }

    @FXML
    void asignarEnvio(ActionEvent event) {
        String idRepartidor = ComboxRepartidor.getValue();
        String idEnvio = comboxEnvio.getValue();
        String estado = txtEstadoEnvio.getText();



        boolean exito = fachada.asignarRepartidorAEnvio(idEnvio, idRepartidor, estado);
        System.out.println("Resultado de fachada: " + exito);

        if (exito) {
            mostrarAlerta(" Repartidor asignado correctamente.");
        } else {
            mostrarAlerta(" No se pudo asignar el repartidor.");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultado");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void Regresar(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
        // Lógica para regresar a la vista anterior (si aplica)
    }

    @FXML
    void SeleccionRepartidor(ActionEvent event) {
        // Opcional: lógica al seleccionar un repartidor
    }

    @FXML
    void seleccionEnvio(ActionEvent event) {
        // Opcional: lógica al seleccionar un envío
    }
}

