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
        for (int col = 0; col<GRID_SIZE; col++){
            for (int row = 0; row<GRID_SIZE; row++){
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.LIGHTGRAY);
                cell.setStrokeWidth(1);
                cell.setStrokeType(StrokeType.INSIDE);
                int currentRow = row;
                int currentCol = col;
                cell.setOnMouseClicked(event -> handleCellClick(currentRow, currentCol, cell));
                grid.add(cell, col, row);
            }
        }
    }

    private void handleCellClick(int row, int col, Rectangle cell){
        cell.setFill(Color.YELLOW);
    }

}
