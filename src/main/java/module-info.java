module org.example.image_converter {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.graphics;
    requires batik.all;

    opens org.example.image_converter to javafx.fxml;
    opens org.example.image_converter.Controllers to javafx.fxml;

    exports org.example.image_converter;
    exports org.example.image_converter.Controllers;
}