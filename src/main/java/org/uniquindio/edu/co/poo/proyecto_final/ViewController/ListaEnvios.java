package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.uniquindio.edu.co.poo.proyecto_final.App;
import org.uniquindio.edu.co.poo.proyecto_final.model.EnvioBuilder;

import java.time.LocalDate;

public class ListaEnvios {

    @FXML
    private TableView<EnvioBuilder> tablaListaEnvios;

    @FXML
    private TableColumn<EnvioBuilder, String> tablaIdEnvio;

    @FXML
    private TableColumn<EnvioBuilder, String> TablaEstadoEnvio;

    @FXML
    private TableColumn<EnvioBuilder, String> TablaDireccionEnvio;

    @FXML
    public void initialize() {
        tablaIdEnvio.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getIdEnvio()));

        TablaEstadoEnvio.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEstadoEnvio()));

        TablaDireccionEnvio.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDireccion().getCalle()));

        tablaListaEnvios.getItems().addAll(App.getFachada().listarEnvios());
    }

    @FXML
    void ClonarEnvio(ActionEvent event) {
        EnvioBuilder seleccionado = tablaListaEnvios.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            System.out.println(" No se ha seleccionado ningún envío");
            return;
        }

        String nuevoId = "ENV" + System.currentTimeMillis();

        EnvioBuilder clon = new EnvioBuilder.Builder(
                nuevoId,
                seleccionado.getEstadoEnvio(),
                LocalDate.now(),
                seleccionado.getDireccion(),
                seleccionado.getTarifa()
        )
                .fechaEstimadaEntrega(seleccionado.getFechaEstimadaEntrega())
                .fechaHoraSalida(seleccionado.getFechaHoraSalida())
                .fechaHoraEntregaReal(seleccionado.getFechaHoraEntregaReal())
                .listaInciencias(seleccionado.getListaIncidencias())
                .repartidor(seleccionado.getRepartidor())
                .usuario(seleccionado.getUsuario())
                .build();

        App.getFachada().registrarEnvio(clon);
        tablaListaEnvios.getItems().add(clon);

        System.out.println(" Envío clonado: " + nuevoId);
    }

    @FXML
    void Regresar(ActionEvent event) {
        tablaListaEnvios.getScene().getWindow().hide();
    }


    @FXML
    void EliminarEnvio(ActionEvent event) {
        EnvioBuilder seleccionado = tablaListaEnvios.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            System.out.println("No se ha seleccionado ningún envío para eliminar");
            return;
        }

        boolean eliminado = App.getFachada().eliminarEnvio(seleccionado.getIdEnvio());

        if (eliminado) {
            tablaListaEnvios.getItems().remove(seleccionado);
            System.out.println(" Envío eliminado: " + seleccionado.getIdEnvio());
        } else {
            System.out.println("No se pudo eliminar el envío");
        }
    }
}