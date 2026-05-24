package ornament_editor;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Cell extends Rectangle {

    private Color color;
    private int xM;
    private int yM;
    private double cellSize;

    public Cell(double size, Color color, int xM, int yM){
        super(size, size);
        cellSize = size;
        this.color = color;
        this.xM = xM;
        this.yM = yM;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getxM() {
        return xM;
    }

    public void setxM(int xM) {
        this.xM = xM;
    }

    public int getyM() {
        return yM;
    }

    public void setyM(int yM) {
        this.yM = yM;
    }

    public double getCellSize() {
        return cellSize;
    }

    public void setCellSize(double cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xM == cell.xM && yM == cell.yM && Objects.equals(color, cell.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, xM, yM);
    }
}
