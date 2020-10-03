package view;

import javafx.scene.canvas.GraphicsContext;
import model.Game;

public class View {
    private GraphicsContext gc;
    private double blockWidth;
    private double blockHeight;

    public View(GraphicsContext gc, double blockWidth, double blockHeight) {
        this.gc = gc;
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
    }

    public void repaint(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            double yTopLeft = i * blockHeight + (blockHeight * 1 / 6);
            double yBottomRight = i * blockHeight + (blockHeight * 5 / 6);
            for (int j = 0; j < board[i].length; j++) {
                double xTopLeft = j * blockWidth + (blockWidth * 1 / 6);
                double xBottomRight = j * blockWidth + (blockWidth * 5 / 6);
                switch (board[i][j]) {
                    case Game.O -> gc.strokeOval(xTopLeft, yTopLeft, blockWidth * 2 / 3, blockHeight * 2 / 3);
                    case Game.X -> {
                        gc.strokeLine(xTopLeft, yTopLeft, xBottomRight, yBottomRight);
                        gc.strokeLine(xTopLeft, yBottomRight, xBottomRight, yTopLeft);
                    }
                }
            }
        }
    }
}
