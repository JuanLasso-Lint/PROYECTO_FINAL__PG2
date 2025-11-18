package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.uniquindio.edu.co.poo.proyecto_final.App;
import org.uniquindio.edu.co.poo.proyecto_final.model.Direccion;
import org.uniquindio.edu.co.poo.proyecto_final.model.PlataformaFacade;
import org.uniquindio.edu.co.poo.proyecto_final.model.Usuario;

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

        tablaIdDirecccion.setCellValueFactory(new PropertyValueFactory<>("idDireccion"));
        tablaAlias.setCellValueFactory(new PropertyValueFactory<>("alias"));
        tablaCalle.setCellValueFactory(new PropertyValueFactory<>("calle"));
        tablaCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        TablaCoorde.setCellValueFactory(new PropertyValueFactory<>("cordenadas"));

        tablaDirecciones.setItems(modeloTabla);
        tablaDirecciones.setOnMouseClicked(this::seleccionarFila);
    }


    @FXML
    void mostrarDireccionesUsuario(ActionEvent event) {
        String cedula = txtCedulaUsuario.getText();

        usuarioActual = fachada.buscarUsuario(cedula);

        if (usuarioActual == null) {
            System.out.println("Usuario no encontrado");
            modeloTabla.clear();
            return;
        }

        modeloTabla.setAll(usuarioActual.getDirecciones());
    }


    @FXML
    void Registrar(ActionEvent event) {

        if (usuarioActual == null) {
            System.out.println("Primero selecciona el usuario");
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




    @FXML
    void eliminar(ActionEvent event) {
        Direccion dir = tablaDirecciones.getSelectionModel().getSelectedItem();

        if (dir == null) {
            System.out.println("Selecciona una fila");
            return;
        }

        boolean ok = fachada.eliminarDireccion(dir.getIdDireccion(), usuarioActual.getIdUsuario());

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



