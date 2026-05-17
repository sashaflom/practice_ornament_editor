package ornament_editor;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class PaintService {

    private static Grid grid;
    private static boolean paint = true;
    private static ColorPicker colorPicker;

    public static void changeCellColor(Cell cell){
        if(paint){
            cell.setFill(colorPicker.getValue());
            cell.setColor(colorPicker.getValue());
        }else{
            cell.setFill(Color.WHITE);
            cell.setColor(Color.WHITE);
        }
    }

    public static void setGrid(Grid newGrid, ColorPicker picker){
        grid = newGrid;
        colorPicker = picker;
    }

    public static void addNewCell(Cell cell){
        grid.addCell(cell);
    }

    public static void changeAction(boolean toWhat){
        paint = toWhat;
    }

    public static void eraseAll(){
        grid.eraseAll();
    }
}
