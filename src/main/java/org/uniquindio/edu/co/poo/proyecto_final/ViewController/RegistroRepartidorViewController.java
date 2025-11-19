package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.uniquindio.edu.co.poo.proyecto_final.model.EstadoRepartidor;
import org.uniquindio.edu.co.poo.proyecto_final.model.PlataformaFacade;
import org.uniquindio.edu.co.poo.proyecto_final.model.Repartidor;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class RegistroRepartidorViewController implements Initializable {

    @FXML
    private TableView<Repartidor> tablaRepartidores;

    @FXML
    private TableColumn<Repartidor, String> TablaID;

    @FXML
    private TableColumn<Repartidor, String> TablaNombre;

    @FXML
    private TableColumn<Repartidor, String> TablaTelefo;

    @FXML
    private TableColumn<Repartidor, String> TablaZonacober;

    @FXML
    private ComboBox<EstadoRepartidor> commboxDiponibilidad;

    @FXML
    private TableColumn<Repartidor, String> tablaEstadoReparti;

    @FXML
    private TableColumn<Repartidor, String> tablaIdRepartidor;

    @FXML
    private TextField txtIdREpartidor;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtZonaCobertura;

    // Facade para acceder a la lógica de negocio
    private PlataformaFacade facade;

    // Lista observable para la tabla
    private ObservableList<Repartidor> listaRepartidores;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializar el facade
        facade = PlataformaFacade.getInstancia();

        // Configurar las columnas de la tabla
        configurarTabla();

        // Cargar los estados en el ComboBox
        commboxDiponibilidad.setItems(FXCollections.observableArrayList(EstadoRepartidor.values()));

        // Cargar los repartidores existentes
        cargarRepartidores();

        // Listener para selección en la tabla
        tablaRepartidores.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetallesRepartidor(newValue)
        );
    }

    /**
     * Configura las columnas de la tabla usando CellValueFactory personalizado
     */
    private void configurarTabla() {
        // Asegurarse de que la tabla tenga el tamaño correcto
        tablaRepartidores.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Usar Callback personalizado para evitar problemas de reflexión con módulos
        TablaID.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getIdRepartidor())
        );

        TablaNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre())
        );

        TablaTelefo.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefono())
        );

        TablaZonacober.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getZonaCobertura())
        );

        tablaEstadoReparti.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEstadoDisponibilidad().toString())
        );

        // Si tienes una columna adicional para ID
        if (tablaIdRepartidor != null) {
            tablaIdRepartidor.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().getIdRepartidor())
            );
        }

        // Hacer que la tabla sea más legible con estilos
        tablaRepartidores.setStyle("-fx-font-size: 14px;");
    }

    /**
     * Carga todos los repartidores desde el facade
     */
    private void cargarRepartidores() {
        listaRepartidores = FXCollections.observableArrayList(facade.listarRepartidores());
        tablaRepartidores.setItems(listaRepartidores);
        tablaRepartidores.refresh(); // Forzar actualización visual
    }

    /**
     * Muestra los detalles del repartidor seleccionado en los campos de texto
     */
    private void mostrarDetallesRepartidor(Repartidor repartidor) {
        if (repartidor != null) {
            txtIdREpartidor.setText(repartidor.getIdRepartidor());
            txtIdentificacion.setText(repartidor.getIdentificacion());
            txtNombre.setText(repartidor.getNombre());
            txtTelefono.setText(repartidor.getTelefono());
            txtZonaCobertura.setText(repartidor.getZonaCobertura());
            commboxDiponibilidad.setValue(repartidor.getEstadoDisponibilidad());
        }
    }

    @FXML
    void RegistrarRepartidor(ActionEvent event) {
        try {
            // Validar campos individualmente para dar feedback específico
            if (txtNombre.getText().trim().isEmpty()) {
                mostrarAlerta("Error de validación", "Debe ingresar el nombre", Alert.AlertType.WARNING);
                return;
            }
            if (txtIdentificacion.getText().trim().isEmpty()) {
                mostrarAlerta("Error de validación", "Debe ingresar la identificación", Alert.AlertType.WARNING);
                return;
            }
            if (txtTelefono.getText().trim().isEmpty()) {
                mostrarAlerta("Error de validación", "Debe ingresar el teléfono", Alert.AlertType.WARNING);
                return;
            }
            if (txtZonaCobertura.getText().trim().isEmpty()) {
                mostrarAlerta("Error de validación", "Debe ingresar la zona de cobertura", Alert.AlertType.WARNING);
                return;
            }
            if (commboxDiponibilidad.getValue() == null) {
                mostrarAlerta("Error de validación", "Debe seleccionar el estado de disponibilidad", Alert.AlertType.WARNING);
                return;
            }

            // El ID del repartidor puede ser el mismo que la identificación o autogenerado
            String idRepartidor = txtIdentificacion.getText().trim();

            // Crear el repartidor con el orden correcto de parámetros
            // Constructor: (nombre, identificacion, telefono, idRepartidor, estadoDisponibilidad, zonaCobertura)
            Repartidor nuevoRepartidor = new Repartidor(
                    txtNombre.getText().trim(),
                    txtIdentificacion.getText().trim(),
                    txtTelefono.getText().trim(),
                    idRepartidor,
                    commboxDiponibilidad.getValue(),
                    txtZonaCobertura.getText().trim()
            );

            // Registrar usando el facade
            // Nota: registrarRepartidor retorna true cuando NO hay error (isEmpty())
            boolean registrado = facade.registrarRepartidor(nuevoRepartidor);

            if (!registrado) {
                mostrarAlerta("Éxito", "Repartidor registrado correctamente", Alert.AlertType.INFORMATION);
                cargarRepartidores();
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar el repartidor. El ID ya existe", Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al registrar el repartidor: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    void EditarRepartidor(ActionEvent event) {
        try {
            // Validar que haya un repartidor seleccionado
            Repartidor seleccionado = tablaRepartidores.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                mostrarAlerta("Error", "Debe seleccionar un repartidor de la tabla", Alert.AlertType.WARNING);
                return;
            }

            // Validar que todos los campos estén llenos
            if (commboxDiponibilidad.getValue() == null ||
                    txtNombre.getText().isEmpty() ||
                    txtIdentificacion.getText().isEmpty() ||
                    txtTelefono.getText().isEmpty() ||
                    txtIdREpartidor.getText().isEmpty() ||
                    txtZonaCobertura.getText().isEmpty()) {

                mostrarAlerta("Error", "Debe llenar todos los campos y seleccionar un estado", Alert.AlertType.WARNING);
                return;
            }

            // Obtener datos del formulario
            String nuevoNombre = txtNombre.getText();
            String nuevaIdentificacion = txtIdentificacion.getText();
            String nuevoTelefono = txtTelefono.getText();
            String nuevoId = txtIdREpartidor.getText();
            EstadoRepartidor nuevoEstado = commboxDiponibilidad.getValue();
            String nuevaZonaCobertura = txtZonaCobertura.getText();

            // ID original para buscar al repartidor
            String idOriginal = seleccionado.getIdRepartidor();

            System.out.println("Editando repartidor con ID original: " + idOriginal);
            System.out.println("Nuevo ID: " + nuevoId + ", Estado: " + nuevoEstado);

            // Llamar al facade con todos los datos
            boolean editado = facade.editarRepartidor(
                    idOriginal,
                    nuevoNombre,
                    nuevaIdentificacion,
                    nuevoTelefono,
                    nuevoId,
                    nuevoEstado,
                    nuevaZonaCobertura
            );

            if (editado) {
                mostrarAlerta("Éxito", "Repartidor editado correctamente", Alert.AlertType.INFORMATION);
                tablaRepartidores.getItems().clear();
                cargarRepartidores();
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo editar el repartidor. Verifique el ID", Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al editar el repartidor: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    void EliminarRepartidor(ActionEvent event) {
        try {
            // Validar que haya un repartidor seleccionado
            Repartidor seleccionado = tablaRepartidores.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                mostrarAlerta("Error", "Debe seleccionar un repartidor de la tabla", Alert.AlertType.WARNING);
                return;
            }

            // Confirmar eliminación
            Optional<ButtonType> resultado = mostrarConfirmacion(
                    "Confirmar eliminación",
                    "¿Está seguro de eliminar al repartidor " + seleccionado.getNombre() + "?"
            );

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                boolean eliminado = facade.eliminarRepartidor(seleccionado.getIdRepartidor());

                if (eliminado) {
                    mostrarAlerta("Éxito", "Repartidor eliminado correctamente", Alert.AlertType.INFORMATION);
                    cargarRepartidores();
                    limpiarCampos();
                } else {
                    mostrarAlerta("Error", "No se pudo eliminar el repartidor", Alert.AlertType.ERROR);
                }
            }

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al eliminar el repartidor: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    void Regresar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Valida que todos los campos requeridos estén completos
     */
    private boolean validarCampos() {
        return !txtIdREpartidor.getText().trim().isEmpty() &&
                !txtIdentificacion.getText().trim().isEmpty() &&
                !txtNombre.getText().trim().isEmpty() &&
                !txtTelefono.getText().trim().isEmpty() &&
                !txtZonaCobertura.getText().trim().isEmpty() &&
                commboxDiponibilidad.getValue() != null;
    }

    /**
     * Limpia todos los campos del formulario
     */
    private void limpiarCampos() {
        txtIdREpartidor.clear();
        txtIdentificacion.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtZonaCobertura.clear();
        commboxDiponibilidad.setValue(null);
        tablaRepartidores.getSelectionModel().clearSelection();
    }

    /**
     * Muestra una alerta al usuario
     */
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Muestra un diálogo de confirmación
     */
    private Optional<ButtonType> mostrarConfirmacion(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        return alerta.showAndWait();
    }
}