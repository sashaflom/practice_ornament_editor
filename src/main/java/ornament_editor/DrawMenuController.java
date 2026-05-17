package ornament_editor;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class DrawMenuController {

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize(){
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        GridService.setGrid(new Grid());
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
                cell.setOnMouseClicked(event -> GridService.changeCellColor(cell));
                gridPane.add(cell, col, row);
                GridService.addNewCell(cell);
            }
        }
    }

}
