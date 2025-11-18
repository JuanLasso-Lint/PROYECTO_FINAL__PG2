package org.uniquindio.edu.co.poo.proyecto_final.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyecto_final.App;
import org.uniquindio.edu.co.poo.proyecto_final.model.Plataforma;
import org.uniquindio.edu.co.poo.proyecto_final.model.PlataformaFacade;
import org.uniquindio.edu.co.poo.proyecto_final.model.Usuario;

import java.io.IOException;

public class RegistrarseUsuarioViewController {

    @FXML
    private TextField nombreU;

    @FXML
    private TextField idU;

    @FXML
    private TextField telefonoU;

    @FXML
    private TextField emailU;

    @FXML
    private TextField idusuarioU;

    Plataforma plataforma = Plataforma.getInstance();

    private final Plataforma plataformas = Plataforma.getInstance();
    App app;
    private final PlataformaFacade plataformaFacade = app.getFachada();


    @FXML
    private void registrarUsuario(ActionEvent event) throws IOException {

        Usuario usuario = new Usuario(
                nombreU.getText(),
                idU.getText(),
                telefonoU.getText(),
                emailU.getText(),
                idusuarioU.getText()
        );

        Usuario registro = plataformaFacade.registrarUsuario(usuario);

        System.out.println(plataformas.getListaUsuarios());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/ProcesoCorrecto.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void regresarInicio(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/poo/proyecto_final/PantallaInicio.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((javafx.scene.control.Button)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

}
