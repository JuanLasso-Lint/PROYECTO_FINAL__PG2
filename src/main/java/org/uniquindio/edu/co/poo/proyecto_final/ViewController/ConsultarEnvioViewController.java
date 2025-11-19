package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.model.EnvioBuilder;
import org.uniquindio.edu.co.poo.proyecto_final.model.EstadoEnvio;
import org.uniquindio.edu.co.poo.proyecto_final.model.Plataforma;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ConsultarEnvioViewController {

    @FXML
    private TableView<EnvioBuilder> listaResultados;

    @FXML
    private TableColumn<EnvioBuilder, String> colId;

    @FXML
    private TableColumn<EnvioBuilder, String> colNombre;

    @FXML
    private TableColumn<EnvioBuilder, EstadoEnvio> colEstado;

    @FXML
    private TextField fechaB;

    @FXML
    private ComboBox<EstadoEnvio> estados;

    Plataforma plataforma = Plataforma.getInstance();

    @FXML
    public void initialize() {

        estados.getItems().addAll(EstadoEnvio.values());

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoEnvio"));
    }

    @FXML
    private void BuscarEnvio(){

        LocalDate fecha = LocalDate.parse(fechaB.getText());
        EstadoEnvio estado = estados.getValue();

        List<EnvioBuilder> resultados = plataforma.buscarEnvios(fecha, estado);

        mostrarResultados(resultados);
    }

    private void mostrarResultados(List<EnvioBuilder> resultados) {
        listaResultados.getItems().clear();
        listaResultados.getItems().addAll(resultados);
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