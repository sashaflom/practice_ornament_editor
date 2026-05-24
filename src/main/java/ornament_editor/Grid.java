package ornament_editor;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private int gridWidth;
    private int gridHeight;
    private double gridWidthPx;
    private double gridHeightPx;
    private List<Cell> gridCells;

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    public double getGridWidthPx() {
        return gridWidthPx;
    }

    public void setGridWidthPx(double gridWidthPx) {
        this.gridWidthPx = gridWidthPx;
    }

    public double getGridHeightPx() {
        return gridHeightPx;
    }

    public void setGridHeightPx(double gridHeightPx) {
        this.gridHeightPx = gridHeightPx;
    }

    public List<Cell> getGridCells() {
        return gridCells;
    }

    public void setGridCells(List<Cell> gridCells) {
        this.gridCells = gridCells;
    }

    public Grid(int width, int height, double widthPx, double heightPx){
        gridCells = new ArrayList<>();
        gridWidth = width;
        gridHeight = height;
        gridWidthPx = widthPx;
        gridHeightPx = heightPx;
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

    public Cell findCellByCoordinates(int x, int y){
        for (Cell cell : gridCells){
            if((cell.getxM() == x) && (cell.getyM() == y)){
                return cell;
            }
        }
        return null;
    }

}
