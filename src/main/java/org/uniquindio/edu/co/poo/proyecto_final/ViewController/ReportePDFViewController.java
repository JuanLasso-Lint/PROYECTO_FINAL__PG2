package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.proyecto_final.model.AdaptadorReporte;
import org.uniquindio.edu.co.poo.proyecto_final.model.ReporteViejo;

public class ReportePDFViewController {

    @FXML
    private TextField nombreReporte;

    @FXML
    private TextField fechaReporte;

    @FXML
    private TextArea contenidoReporte;

    @FXML
    private Button btnGenerar;

    @FXML
    private Button btnImprimir;

    private AdaptadorReporte adaptador;

    @FXML
    public void initialize() {
        btnGenerar.setOnAction(e -> generarReporte());
        btnImprimir.setOnAction(e -> imprimirReporte());
    }

    private void generarReporte() {
        String nombre = nombreReporte.getText();
        String fecha = fechaReporte.getText();
        String contenido = contenidoReporte.getText();

        if (nombre.isEmpty() || fecha.isEmpty() || contenido.isEmpty()) {
            mostrarAlerta("Error", "Por favor complete todos los campos");
            return;
        }

        ReporteViejo reporteViejo = new ReporteViejo(nombre, fecha, contenido);
        adaptador = new AdaptadorReporte(reporteViejo);

        adaptador.generarReporte(); // <-- GENERA EL PDF

        mostrarAlerta("Éxito", "PDF generado correctamente");
    }

    private void imprimirReporte() {
        if (adaptador == null) {
            mostrarAlerta("Error", "Debe generar el reporte primero");
            return;
        }

        adaptador.imprimirReporte();
        mostrarAlerta("Impresión", "Reporte enviado a impresión (simulado)");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}