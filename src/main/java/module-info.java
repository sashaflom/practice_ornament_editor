module ornament_editor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    requires java.desktop;

    opens ornament_editor to javafx.fxml;
    exports ornament_editor;
}