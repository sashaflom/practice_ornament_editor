package ornament_editor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class InsctructionController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToDrawingMode(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ornament_editor/drawMenu.fxml"));
        MenuItem menuItem = (MenuItem)event.getSource();
        stage = (Stage)menuItem.getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ornament_editor/mainMenu.fxml"));
        MenuItem menuItem = (MenuItem)event.getSource();
        stage = (Stage)menuItem.getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
