package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.App;
import org.uniquindio.edu.co.poo.proyecto_final.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class CrearEnvioViewController {

    @FXML private ComboBox<Direccion> SeleccionDirecciones;
    @FXML private ComboBox<TipoDistancia> distanciaE;
    @FXML private ComboBox<String> servicioA;
    @FXML private Button btnCargarDirecciones;
    @FXML private TextField txtcedulaUsuario;
    @FXML private TextField idE;
    @FXML private TextField fechaE;
    @FXML private TextField horaE;
    @FXML private TextField pesoE;
    @FXML private TextField volumenE;
    @FXML private ComboBox<TipoPrioridad> prioridadE;

    private final PlataformaFacade fachada = App.getFachada();

    @FXML
    public void initialize() {
        // Inicializar ComboBoxes con valores
        distanciaE.getItems().addAll(TipoDistancia.values());
        prioridadE.getItems().addAll(TipoPrioridad.values());
        servicioA.getItems().addAll("NINGUNO", "FRAGIL", "PRIORIDAD", "SEGURO");

        // Seleccionar "NINGUNO" por defecto en servicios adicionales
        servicioA.setValue("NINGUNO");
    }

    @FXML
    void seleccionDirecciones(ActionEvent event) {
        // Este método se ejecuta cuando el usuario selecciona una dirección del ComboBox
        Direccion direccionSeleccionada = SeleccionDirecciones.getValue();

        if (direccionSeleccionada != null) {
            System.out.println("Dirección seleccionada: " + direccionSeleccionada);
        }
    }

    @FXML
    void CargarDireccionesUsuario(ActionEvent event) {
        String cedula = txtcedulaUsuario.getText().trim();

        // Validar que la cédula no esté vacía
        if (cedula.isEmpty()) {
            mostrarAlerta("Error", "Debes ingresar una cédula", Alert.AlertType.WARNING);
            return;
        }

        // Buscar usuario
        Usuario usuario = fachada.buscarUsuario(cedula);

        if (usuario == null) {
            mostrarAlerta("Error", "El usuario no existe", Alert.AlertType.ERROR);
            SeleccionDirecciones.getItems().clear();
            return;
        }

        // Obtener direcciones del usuario
        List<Direccion> direcciones = usuario.getDirecciones();

        if (direcciones == null || direcciones.isEmpty()) {
            mostrarAlerta("Aviso", "El usuario no tiene direcciones registradas", Alert.AlertType.INFORMATION);
            SeleccionDirecciones.getItems().clear();
            return;
        }

        // Cargar direcciones en el ComboBox
        SeleccionDirecciones.getItems().setAll(direcciones);
        mostrarAlerta("Éxito", "Direcciones cargadas correctamente", Alert.AlertType.INFORMATION);
    }

    @FXML
    void crearEnvio(ActionEvent event) {
        try {
            // Validaciones de campos obligatorios
            if (!validarCampos()) {
                return;
            }

        servicioA.getItems().addAll("NINGUNO", "FRAGIL", "PRIORIDAD", "SEGURO");
    }

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Peso y volumen deben ser números válidos", Alert.AlertType.ERROR);
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al crear envío: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();

            System.out.println(App.getPlataforma().getListaEnvios());
        }
    }

    List<Direccion> direcciones = usuario.getDirecciones();
    SeleccionDirecciones.getItems().setAll(direcciones);
}

    @FXML
    void regresarInicio(ActionEvent event) {
        try {
            navegarAPagina("/org/uniquindio/edu/co/poo/proyecto_final/PaginaUsuario.fxml");
        } catch (IOException e) {
            mostrarAlerta("Error", "Error al regresar: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // Métodos auxiliares
    private boolean validarCampos() {
        if (txtcedulaUsuario.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "Debes ingresar la cédula del usuario", Alert.AlertType.WARNING);
            return false;
        }

        if (idE.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "Debes ingresar el ID del envío", Alert.AlertType.WARNING);
            return false;
        }

        if (pesoE.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "Debes ingresar el peso", Alert.AlertType.WARNING);
            return false;
        }

        if (volumenE.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "Debes ingresar el volumen", Alert.AlertType.WARNING);
            return false;
        }

        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void navegarAPagina(String rutaFXML) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) idE.getScene().getWindow();
        stage.setScene(scene);
    }
}