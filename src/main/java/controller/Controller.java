package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Game;
import view.View;

public class Controller {
    @FXML
    private Canvas canvas;

    private Game game = new Game();
    private View view;
    private double blockWidth;
    private double blockHeight;

    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        blockWidth = width / 3;
        blockHeight = height / 3;
        // Draw board
        gc.strokeLine(blockWidth, 0, blockWidth, height);
        gc.strokeLine(blockWidth * 2, 0, blockWidth * 2, height);
        gc.strokeLine(0, blockHeight, width, blockHeight);
        gc.strokeLine(0, blockHeight * 2, width, blockHeight * 2);
        //Start the game
        view = new View(gc, blockWidth, blockHeight);
        game.start(view);
    }

    @FXML
    public void clicked(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        int j = (int) (x/blockWidth);
        int i = (int) (y/blockHeight);
        game.nextTurn(i,j);
    }


}
