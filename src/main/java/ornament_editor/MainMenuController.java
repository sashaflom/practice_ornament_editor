package ornament_editor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private GridPane gridPane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void initialize(){
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        for (int row = 0; row<Grid.getGridSize(); row++){
            for (int col = 0; col<Grid.getGridSize(); col++){
                int currentCol = col;
                int currentRow = row;
                Color color = Color.WHITE;
                Cell cell = new Cell(color, currentCol, currentRow);
                cell.setFill(color);
                cell.setStroke(Color.LIGHTGRAY);
                cell.setStrokeWidth(1);
                cell.setStrokeType(StrokeType.INSIDE);
                gridPane.add(cell, col, row);
            }
        }
    }

    public void switchToDrawingMode(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ornament_editor/drawMenu.fxml"));
        MenuItem menuItem = (MenuItem)event.getSource();
        stage = (Stage)menuItem.getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToInstruction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ornament_editor/instruction.fxml"));
        MenuItem menuItem = (MenuItem)event.getSource();
        stage = (Stage)menuItem.getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
