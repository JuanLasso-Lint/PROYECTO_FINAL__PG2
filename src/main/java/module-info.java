module org.uniquindio.edu.co.poo.proyecto_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;
    requires itextpdf;

    opens org.uniquindio.edu.co.poo.proyecto_final to javafx.fxml;
    opens org.uniquindio.edu.co.poo.proyecto_final.ViewController to javafx.fxml;

    exports org.uniquindio.edu.co.poo.proyecto_final.model to javafx.base;
    exports org.uniquindio.edu.co.poo.proyecto_final;
    exports org.uniquindio.edu.co.poo.proyecto_final.ViewController;

}
