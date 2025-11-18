package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.App;
import org.uniquindio.edu.co.poo.proyecto_final.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CrearEnvioViewController {

    @FXML private ComboBox<Direccion> SeleccionDirecciones;
    @FXML private ComboBox<TipoDistancia> distanciaE;
    @FXML private ComboBox<String> servicioA;

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
        distanciaE.getItems().addAll(TipoDistancia.values());
        prioridadE.getItems().addAll(TipoPrioridad.values());

        servicioA.getItems().addAll("NINGUNO", "FRAGIL", "PRIORIDAD", "SEGURO");
    }
/**

    public void crearEnvio(ActionEvent event) throws IOException {

        try {
            String idEnvio = idenvio.getText();
            String direccionTxt = direccionE.getText();

            double peso = Double.parseDouble(pesoE.getText());
            double volumen = Double.parseDouble(volumenE.getText());

            TipoDistancia distancia = distanciaE.getValue();
            TipoPrioridad prioridad = prioridadE.getValue();
            String adicional = servicioA.getValue();

            Tarifa tarifa = new Tarifa(
                    peso,
                    volumen,
                    prioridad,
                    0,
                    distancia
            );

            EnvioBuilder envio = new EnvioBuilder.Builder(
                    idEnvio,
                    "CREADO",
                    java.time.LocalDate.now(),
                    new Direccion(direccionTxt),
                    tarifa
            ).build();

            IEnvio envioFinal = envio;

            switch (adicional) {
                case "FRAGIL" -> envioFinal = new EnvioFragil(envioFinal);
                case "PRIORIDAD" -> envioFinal = new EnvioPrioridad(envioFinal);
                case "SEGURO" -> envioFinal = new EnvioSeguro(envioFinal);
            }

        } catch (Exception e) {
            System.out.println("Error guardando envío: " + e.getMessage());
    void SelcDirecciones(ActionEvent event) {
        String cedula = txtcedulaUsuario.getText();

        Usuario usuario = fachada.buscarUsuario(cedula);
        if (usuario == null) {
            System.out.println("Usuario no existe");
            return;
        }

        List<Direccion> direcciones = usuario.getDirecciones();
        SeleccionDirecciones.getItems().setAll(direcciones);
    }
    **/
    @FXML
    void crearEnvio(ActionEvent event) throws IOException {

        String idEnvio = idE.getText();
        String cedula = txtcedulaUsuario.getText();
        Usuario usuario = fachada.buscarUsuario(cedula);

        if (usuario == null) {
            System.out.println("Usuario no existe");
            return;
        }

        Direccion direccion = SeleccionDirecciones.getValue();
        if (direccion == null) {
            System.out.println("Debes seleccionar una dirección");
            return;
        }

        double peso = Double.parseDouble(pesoE.getText());
        double volumen = Double.parseDouble(volumenE.getText());

        TipoDistancia tipoD = distanciaE.getValue();
        TipoPrioridad tipoP = prioridadE.getValue();
        String adicional = servicioA.getValue();

        Tarifa tarifa = new Tarifa(
                peso,
                volumen,
                tipoP,
                0,
                tipoD
        );

        EnvioBuilder envioBase = new EnvioBuilder.Builder(
                idEnvio,
                "CREADO",
                LocalDate.now(),
                direccion,
                tarifa
        ).usuario(usuario).build();

        IEnvio envioFinal = envioBase;

        switch (adicional) {
            case "FRAGIL" -> envioFinal = new EnvioFragil(envioFinal);
            case "PRIORIDAD" -> envioFinal = new EnvioPrioridad(envioFinal);
            case "SEGURO" -> envioFinal = new EnvioSeguro(envioFinal);
        }

        fachada.registrarEnvio(envioBase);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/org/uniquindio/edu/co/poo/proyecto_final/ProcesoCorrecto.fxml"
        ));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) idE.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void regresarInicio(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/org/uniquindio/edu/co/poo/proyecto_final/PaginaUsuario.fxml"
        ));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) idE.getScene().getWindow();
        stage.setScene(scene);
    }
}
