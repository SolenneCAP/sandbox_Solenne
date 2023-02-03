module fr.simplon.resistron {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.simplon.resistron to javafx.fxml;
    exports fr.simplon.resistron;
}