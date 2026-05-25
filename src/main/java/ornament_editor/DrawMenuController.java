package ornament_editor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.IOException;

public class DrawMenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private GridPane gridPane;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private CheckBox horizontalSymmetry;
    @FXML
    private CheckBox verticalSymmetry;
    @FXML
    private CheckBox centerSymmetry;
    @FXML
    private CheckBox horizontalDuplication;
    @FXML
    private CheckBox verticalDuplication;

    @FXML
    public void initialize(){
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        gridPane.setSnapToPixel(false);
        Grid grid = new Grid(30, 30, 650, 650);
        PaintService.setGrid(gridPane, grid, colorPicker);
        for (int row = 0; row<grid.getGridHeight(); row++){
            for (int col = 0; col<grid.getGridWidth(); col++){
                int currentCol = col;
                int currentRow = row;
                Color color = Color.WHITE;
                double cellSize = grid.getGridWidthPx()/grid.getGridWidth() - 2;
                Cell cell = new Cell(cellSize, color, currentCol, currentRow);
                cell.setFill(color);
                cell.setStroke(Color.LIGHTGRAY);
                cell.setStrokeWidth(1);
                cell.setStrokeType(StrokeType.INSIDE);
                cell.setOnMouseClicked(event -> PaintService.changeCellColor(cell));
                gridPane.add(cell, col, row);
                PaintService.addNewCell(cell);
            }
        }
    }

    public void setPaint(){
        PaintService.changeAction(true);
    }

    public void setErase(){
        PaintService.changeAction(false);
    }

    public void eraseAll(){
        PaintService.eraseAll();
    }

    public void changeHorizontalSymmetry(){
        if (horizontalSymmetry.isSelected()){
            PaintService.changeHorizontalSymmetry(true);
        } else{
            PaintService.changeHorizontalSymmetry(false);
        }
    }

    public void changeVerticalSymmetry(){
        if (verticalSymmetry.isSelected()){
            PaintService.changeVerticalSymmetry(true);
        } else{
            PaintService.changeVerticalSymmetry(false);
        }
    }

    public void changeCenterSymmetry(){
        if (centerSymmetry.isSelected()){
            PaintService.changeCenterSymmetry(true);
        } else{
            PaintService.changeCenterSymmetry(false);
        }
    }

    public void switchToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ornament_editor/mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void duplicate(){
        if(horizontalDuplication.isSelected()){
            PaintService.duplicateHorizontal();
        }
        if(verticalDuplication.isSelected()){
            PaintService.duplicateVertical();
        }
    }

    public void save(){
        PaintService.saveToPng();
    }

}
