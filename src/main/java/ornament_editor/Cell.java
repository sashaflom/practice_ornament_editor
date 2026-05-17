package ornament_editor;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    private Color color;
    private int xM;
    private int yM;
    private static final int CELL_SIZE = 20;

    public Cell(Color color, int xM, int yM){
        super(CELL_SIZE, CELL_SIZE);
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

    public int getyM() {
        return yM;
    }

    public static int getCellSize(){
        return CELL_SIZE;
    }
}
