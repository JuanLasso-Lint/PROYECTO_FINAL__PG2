module org.uniquindio.edu.co.poo.proyecto_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.uniquindio.edu.co.poo.proyecto_final to javafx.fxml;
    exports org.uniquindio.edu.co.poo.proyecto_final;
}