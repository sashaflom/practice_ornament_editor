package ornament_editor;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class DrawMenuController {

    @FXML
    private GridPane grid;

    private static final int GRID_SIZE = 30;
    private static final int CELL_SIZE = 20;

    @FXML
    public void initialize(){
        grid.setHgap(0);
        grid.setVgap(0);
        for (int i = 0; i<GRID_SIZE; i++){
            for (int j = 0; j<GRID_SIZE; j++){
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.LIGHTGRAY);
                cell.setStrokeWidth(1);
                cell.setStrokeType(StrokeType.INSIDE);
                grid.add(cell, i, j);
            }
        }
    }

}
