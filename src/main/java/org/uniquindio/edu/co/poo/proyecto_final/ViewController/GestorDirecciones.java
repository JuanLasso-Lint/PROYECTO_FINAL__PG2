package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.App;
import org.uniquindio.edu.co.poo.proyecto_final.model.Direccion;
import org.uniquindio.edu.co.poo.proyecto_final.model.PlataformaFacade;
import org.uniquindio.edu.co.poo.proyecto_final.model.Usuario;

import java.io.IOException;

public class GestorDirecciones {

    @FXML private TableColumn<Direccion, String> TablaCoorde;
    @FXML private TableColumn<Direccion, String> tablaAlias;
    @FXML private TableColumn<Direccion, String> tablaCalle;
    @FXML private TableColumn<Direccion, String> tablaCiudad;
    @FXML private TableColumn<Direccion, String> tablaIdDirecccion;

    @FXML private TableView<Direccion> tablaDirecciones;

    @FXML private TextField txtAlias;
    @FXML private TextField txtCalle;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtCoordenadas;
    @FXML private TextField txtIdDireccion;

    // AGREGAR ESTE CAMPO EN TU FXML
    @FXML private TextField txtCedulaUsuario;

    private final PlataformaFacade fachada = App.getFachada();
    private Usuario usuarioActual;
    private ObservableList<Direccion> modeloTabla = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        tablaIdDirecccion.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getIdDireccion())
        );

        tablaAlias.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAlias())
        );

        tablaCalle.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCalle())
        );

        tablaCiudad.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCiudad())
        );

        TablaCoorde.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCordenadas())
        );

        tablaDirecciones.setItems(modeloTabla);
        tablaDirecciones.setOnMouseClicked(this::seleccionarFila);
    }

    @FXML
    void Regresar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/OpcionesUsuario.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }
/**
    @FXML
    void ObternerUsuario(ActionEvent event) {
        String cedula = txtCedulaUsuario.getText();

        usuarioActual = fachada.buscarUsuario(cedula);

    }
**/

@FXML
void ObternerUsuario(ActionEvent event) {
    String cedula = txtCedulaUsuario.getText().trim();

    if (cedula.isEmpty()) {
        mostrarAlerta("Error", "Ingrese la cédula del usuario");
        return;
    }

    usuarioActual = fachada.buscarUsuario(cedula);

    if (usuarioActual == null) {
        mostrarAlerta("Error", "Usuario no encontrado con cédula: " + cedula);
    } else {
        mostrarAlerta("Éxito", "Usuario encontrado: " + usuarioActual.getNombre());
        mostrarDireccionesUsuario(null);
    }
}



    @FXML
    void mostrarDireccionesUsuario(ActionEvent event) {


        if (usuarioActual == null) {
            System.out.println("Usuario no encontrado");
            modeloTabla.clear();
            return;
        }

        modeloTabla.setAll(usuarioActual.getDirecciones());
    }

/**

    void Registrar(ActionEvent event) {

        if (usuarioActual == null) {
            System.out.println("Primero selecciona el usuario o el usuario no encontrado");
            return;
        }

        String id = txtIdDireccion.getText();
        String alias = txtAlias.getText();
        String calle = txtCalle.getText();
        String ciudad = txtCiudad.getText();
        String coordenadas = txtCoordenadas.getText();

        Direccion nueva = new Direccion(
                id,
                alias,
                calle,
                ciudad,
                coordenadas
        );

        boolean creada = fachada.agregarDireccion(usuarioActual.getIdUsuario(), nueva);

        if (creada) {
            modeloTabla.add(nueva);
            limpiarCampos();
            System.out.println("Dirección agregada");
        } else {
            System.out.println("No se logró agregar la dirección");
        }
    }
**/

@FXML
void Registrar(ActionEvent event) {
    if (usuarioActual == null) {
        mostrarAlerta("Error", "Primero seleccione un usuario");
        return;
    }

    // Validar campos
    if (!validarCampos()) {
        return;
    }

    String id = txtIdDireccion.getText().trim();
    String alias = txtAlias.getText().trim();
    String calle = txtCalle.getText().trim();
    String ciudad = txtCiudad.getText().trim();
    String coordenadas = txtCoordenadas.getText().trim();

    Direccion nueva = new Direccion(id, alias, calle, ciudad, coordenadas);
    boolean creada = fachada.agregarDireccion(usuarioActual.getIdUsuario(), nueva);

    if (creada) {
        modeloTabla.add(nueva);
        limpiarCampos();
        mostrarAlerta("Éxito", "Dirección agregada correctamente");
    } else {
        mostrarAlerta("Error", "No se pudo agregar la dirección. El ID puede estar duplicado");
    }
}

    private boolean validarCampos() {
        if (txtIdDireccion.getText().trim().isEmpty() ||
                txtAlias.getText().trim().isEmpty() ||
                txtCalle.getText().trim().isEmpty() ||
                txtCiudad.getText().trim().isEmpty()) {

            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return false;
        }
        return true;
    }




    @FXML
    void Editar(ActionEvent event) {

        Direccion seleccionada = tablaDirecciones.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            System.out.println("Selecciona una fila");
            return;
        }

        // Actualizas la dirección con los valores del formulario
        seleccionada.setAlias(txtAlias.getText());
        seleccionada.setCalle(txtCalle.getText());
        seleccionada.setCiudad(txtCiudad.getText());
        seleccionada.setCordenadas(txtCoordenadas.getText());

        // Llamas a la fachada usando USUARIO + DIRECCION
        boolean ok = fachada.editarDireccion(
                usuarioActual.getIdUsuario(),
                seleccionada
        );

        if (ok) {
            tablaDirecciones.refresh();
            limpiarCampos();
            System.out.println("Dirección editada");
        } else {
            System.out.println("No fue posible editar la dirección");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }




    @FXML
    void eliminar(ActionEvent event) {
        Direccion dir = tablaDirecciones.getSelectionModel().getSelectedItem();

        if (dir == null) {
            System.out.println("Selecciona una fila");
            return;
        }

        boolean ok = fachada.eliminarDireccion(usuarioActual.getIdUsuario(),dir.getIdDireccion());

        if (ok) {
            modeloTabla.remove(dir);
            limpiarCampos();
        }
    }


    private void seleccionarFila(MouseEvent e) {
        Direccion d = tablaDirecciones.getSelectionModel().getSelectedItem();
        if (d == null) return;

        txtIdDireccion.setText(d.getIdDireccion());
        txtAlias.setText(d.getAlias());
        txtCalle.setText(d.getCalle());
        txtCiudad.setText(d.getCiudad());
        txtCoordenadas.setText(d.getCordenadas());
    }


    private void limpiarCampos() {
        txtIdDireccion.clear();
        txtAlias.clear();
        txtCalle.clear();
        txtCiudad.clear();
        txtCoordenadas.clear();
    }
}



