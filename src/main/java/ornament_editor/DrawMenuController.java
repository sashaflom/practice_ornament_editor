package ornament_editor;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.util.ArrayList;
import java.util.List;

public class DrawMenuController {

    @FXML
    private GridPane grid;
    List<Rectangle> gridCells = new ArrayList<>();

    private static final int GRID_SIZE = 30;
    private static final int CELL_SIZE = 20;

    @FXML
    public void initialize(){
        grid.setHgap(0);
        grid.setVgap(0);
        for (int row = 0; row<GRID_SIZE; row++){
            for (int col = 0; col<GRID_SIZE; col++){
                int currentRow = row;
                int currentCol = col;
                Cell cell = new Cell(CELL_SIZE, CELL_SIZE, Color.WHITE, currentRow, currentCol);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.LIGHTGRAY);
                cell.setStrokeWidth(1);
                cell.setStrokeType(StrokeType.INSIDE);
                cell.setOnMouseClicked(event -> handleCellClick(currentRow, currentCol, cell));
                grid.add(cell, col, row);
            }
        }
    }

    private void handleCellClick(int row, int col, Rectangle cell){
        cell.setFill(Color.YELLOW);
    }

}
