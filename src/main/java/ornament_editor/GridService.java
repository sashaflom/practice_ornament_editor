package ornament_editor;

import javafx.scene.paint.Color;

public class GridService {

    private static Grid grid;

    public static void changeCellColor(Cell cell){
        cell.setFill(Color.YELLOW);

    }

    public static void setGrid(Grid newGrid){
        grid = newGrid;
    }

    public static void addNewCell(Cell cell){
        grid.addCell(cell);
    }

}
