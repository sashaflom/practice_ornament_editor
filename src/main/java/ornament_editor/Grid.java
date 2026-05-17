package ornament_editor;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private static final int GRID_SIZE = 30;
    List<Cell> gridCells;

    public static int getGridSize(){
        return GRID_SIZE;
    }

    public Grid(){
        gridCells = new ArrayList<>();
    }

    public void addCell(Cell cell){
        gridCells.add(cell);
    }

    public void eraseAll(){
        for (Cell cell : gridCells){
            cell.setFill(Color.WHITE);
            cell.setColor(Color.WHITE);
        }
    }

}
