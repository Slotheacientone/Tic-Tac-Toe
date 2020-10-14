package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Game;
import view.View;

public class Controller {
    @FXML
    private Canvas canvas;
    @FXML
    private Button restartButton;
    @FXML
    private Label xWin;
    @FXML
    private Label oWin;

    private Game game = new Game();
    private View view;
    private double blockWidth;
    private double blockHeight;
    private GraphicsContext gc;
    boolean win = false;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        blockWidth = canvas.getWidth() / 3;
        blockHeight = canvas.getHeight() / 3;
        //Start the game
        view = new View(gc, blockWidth, blockHeight);
        view.drawBoard();
        game.restart();
    }

    @FXML
    public void clicked(MouseEvent event) throws InterruptedException {
        if (win) {
            return;
        }
        double x = event.getX();
        double y = event.getY();
        int j = (int) (x / blockWidth);
        int i = (int) (y / blockHeight);
        char result = game.nextTurn(i, j);
        if (result == 'f') {
            return;
        }
        if (result != 0) {
            win = true;
        }
        view.repaint(game.getBoard());
        switch (result) {
            case 'x' -> {
                game.addXWinCount();
                xWin.setText("X:" + game.getXWinCount());
            }
            case 'o' -> {
                game.addOWinCount();
                oWin.setText("O:" + game.getOWinCount());
            }
            case 'd' -> {
                game.addXWinCount();
                xWin.setText("X:" + game.getXWinCount());
                game.addOWinCount();
                oWin.setText("O:" + game.getOWinCount());
            }
        }
    }

    @FXML
    void clickedRestartButton(MouseEvent event) {
        game.clearBoard();
        view.drawBoard();
        game.restart();
        win = false;
    }
}
