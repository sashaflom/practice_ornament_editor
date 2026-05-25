package ornament_editor;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PaintService {

    private static Grid grid;
    private static GridPane gridPane;
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

    public static void setGrid(GridPane newGridPane, Grid newGrid, ColorPicker picker) {
        gridPane = newGridPane;
        grid = newGrid;
        colorPicker = picker;
        paint = true;
        horizontalSymmetry = false;
        verticalSymmetry = false;
        centerSymmetry = false;
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

    public static void duplicateHorizontal(){
        int previousWidth = grid.getGridWidth();
        int newWidth = previousWidth*2;
        grid.setGridWidth(newWidth);
        double previousStrokeWidth = grid.findCellByCoordinates(0,0).getStrokeWidth();
        double newStrokeWidth = previousStrokeWidth/2;
        double newCellSize = grid.getGridWidthPx()/grid.getGridWidth() - newStrokeWidth*2;
        for(Cell cell : grid.getGridCells()){
            cell.setCellSize(newCellSize);
            cell.setWidth(newCellSize);
            cell.setHeight(newCellSize);
            cell.setStrokeWidth(newStrokeWidth);
        }
        for (int row = 0; row<grid.getGridHeight(); row++){
            for (int col = previousWidth; col<grid.getGridWidth(); col++){
                int currentCol = col;
                int currentRow = row;
                Color color = grid.findCellByCoordinates(currentCol-30, currentRow).getColor();
                Cell cell = new Cell(newCellSize, color, currentCol, currentRow);
                cell.setFill(color);
                cell.setStroke(Color.LIGHTGRAY);
                cell.setStrokeWidth(newStrokeWidth);
                cell.setStrokeType(StrokeType.INSIDE);
                cell.setOnMouseClicked(event -> PaintService.changeCellColor(cell));
                gridPane.add(cell, col, row);
                PaintService.addNewCell(cell);
            }
        }
    }

    public static void duplicateVertical(){
        int previousHeight = grid.getGridHeight();
        int newHeight = previousHeight*2;
        grid.setGridHeight(newHeight);
        double previousStrokeWidth = grid.findCellByCoordinates(0,0).getStrokeWidth();
        double newStrokeWidth = previousStrokeWidth/2;
        double newCellSize = grid.getGridHeightPx()/grid.getGridHeight() - newStrokeWidth*2;
        for(Cell cell : grid.getGridCells()){
            cell.setCellSize(newCellSize);
            cell.setWidth(newCellSize);
            cell.setHeight(newCellSize);
            cell.setStrokeWidth(newStrokeWidth);
        }
        for (int row = previousHeight; row<grid.getGridHeight(); row++){
            for (int col = 0; col<grid.getGridWidth(); col++){
                int currentCol = col;
                int currentRow = row;
                Color color = grid.findCellByCoordinates(currentCol, currentRow - 30).getColor();
                Cell cell = new Cell(newCellSize, color, currentCol, currentRow);
                cell.setFill(color);
                cell.setStroke(Color.LIGHTGRAY);
                cell.setStrokeWidth(newStrokeWidth);
                cell.setStrokeType(StrokeType.INSIDE);
                cell.setOnMouseClicked(event -> PaintService.changeCellColor(cell));
                gridPane.add(cell, col, row);
                PaintService.addNewCell(cell);
            }
        }
    }

    public static void saveToPng(){
        int width = grid.getGridWidth();
        int height = grid.getGridHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = grid.findCellByCoordinates(x, y);
                Color color = (cell != null) ? cell.getColor() : Color.WHITE;
                pixelWriter.setColor(x, y, color);
            }
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Зберегти схему орнаменту");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG зображення", "*.png"));

        Stage stage = (Stage) gridPane.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void download(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Завантажити схему орнаменту");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG зображення", "*.png"));

        Stage stage = (Stage) gridPane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            try {
                WritableImage image = SwingFXUtils.toFXImage(ImageIO.read(file), null);
                PixelReader pixelReader = image.getPixelReader();

                int imgWidth = (int) image.getWidth();
                int imgHeight = (int) image.getHeight();

                int max = Math.max(imgWidth, imgHeight);
                double strokeWidth;
                if(max == 30){
                    strokeWidth = 1;
                }else{
                    strokeWidth = 0.5;
                }

                grid.setGridWidth(imgWidth);
                grid.setGridHeight(imgHeight);
                for (int row = 0; row<grid.getGridHeight(); row++){
                    for (int col = 0; col<grid.getGridWidth(); col++){
                        int currentCol = col;
                        int currentRow = row;
                        Color color = pixelReader.getColor(col, row);
                        double cellSize = grid.getGridWidthPx()/grid.getGridWidth() - 2*strokeWidth;
                        Cell cell = new Cell(cellSize, color, currentCol, currentRow);
                        cell.setFill(color);
                        cell.setStroke(Color.LIGHTGRAY);
                        cell.setStrokeWidth(strokeWidth);
                        cell.setStrokeType(StrokeType.INSIDE);
                        cell.setOnMouseClicked(event -> PaintService.changeCellColor(cell));
                        gridPane.add(cell, col, row);
                        PaintService.addNewCell(cell);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
