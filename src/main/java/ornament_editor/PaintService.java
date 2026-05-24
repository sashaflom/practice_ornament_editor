package ornament_editor;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class PaintService {

    private static Grid grid;
    private static boolean paint = true;
    private static boolean horizontalSymmetry = false;
    private static boolean verticalSymmetry = false;
    private static boolean centerSymmetry = false;
    private static ColorPicker colorPicker;

    public static void changeCellColor(Cell cell){
        Color chosenColor;
        if(paint){
            chosenColor = colorPicker.getValue();
        }else{
            chosenColor = Color.WHITE;
        }
        cell.setFill(chosenColor);
        cell.setColor(chosenColor);
        if(horizontalSymmetry ){
            Cell symmetryCell = grid.findCellByCoordinates(cell.getxM(), (grid.getGridHeight() - 1 - cell.getyM()));
            symmetryCell.setFill(chosenColor);
            symmetryCell.setColor(chosenColor);
        }
        if(verticalSymmetry){
            Cell symmetryCell = grid.findCellByCoordinates((grid.getGridWidth() - 1 - cell.getxM()), cell.getyM());
            symmetryCell.setFill(chosenColor);
            symmetryCell.setColor(chosenColor);
        }
        if(centerSymmetry){
            Cell symmetryHorCell = grid.findCellByCoordinates(cell.getxM(), (grid.getGridHeight() - 1 - cell.getyM()));
            Cell symmetryVerCell = grid.findCellByCoordinates((grid.getGridWidth() - 1 - symmetryHorCell.getxM()), symmetryHorCell.getyM());
            symmetryVerCell.setFill(chosenColor);
            symmetryVerCell.setColor(chosenColor);
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

    public static void changeHorizontalSymmetry(boolean toWhat){
        horizontalSymmetry = toWhat;
    }

    public static void changeVerticalSymmetry(boolean toWhat){
        verticalSymmetry = toWhat;
    }

    public static void changeCenterSymmetry(boolean toWhat){
        centerSymmetry = toWhat;
    }
}
