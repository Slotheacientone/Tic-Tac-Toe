package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Game;

public class Controller {
    @FXML
    private Canvas canvas;

    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        double blockWidth = width / 3;
        double blockHeight = height / 3;
        // Draw board
        gc.strokeLine(blockWidth, 0, blockWidth, height);
        gc.strokeLine(blockWidth * 2, 0, blockWidth * 2, height);
        gc.strokeLine(0, blockHeight, width, blockHeight);
        gc.strokeLine(0, blockHeight * 2, width, blockHeight * 2);
        //Start the game
        Game game = new Game();
        game.start(gc,width,height,blockWidth,blockHeight);
    }

}
