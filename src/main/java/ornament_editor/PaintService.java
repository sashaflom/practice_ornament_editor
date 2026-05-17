package ornament_editor;

import javafx.scene.paint.Color;

public class PaintService {

    private static Grid grid;
    private static boolean paint = true;

    public static void changeCellColor(Cell cell){
        if(paint){
            cell.setFill(Color.YELLOW);
            cell.setColor(Color.YELLOW);
        }else{
            cell.setFill(Color.WHITE);
            cell.setColor(Color.WHITE);
        }
    }

    public static void setGrid(Grid newGrid){
        grid = newGrid;
    }

    public static void addNewCell(Cell cell){
        grid.addCell(cell);
    }

    public static void changeAction(boolean toWhat){
        paint = toWhat;
    }
}
