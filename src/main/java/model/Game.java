package model;

import javafx.scene.canvas.GraphicsContext;

public class Game {
    public final static int X = 1;
    public final static int O = 2;
    public int[][] board = {{X, O, X}, {O, X, O}, {X, O, X}};
    public void start(GraphicsContext gc, double width, double height, double blockWidth, double blockHeight) {
        repaint(gc, width, height, blockWidth, blockHeight);
    }
//Paint X and O
    public void repaint(GraphicsContext gc, double width, double height, double blockWidth, double blockHeight) {
        for (int i = 0; i < board.length; i++) {
            double yTopLeft = i * blockHeight + (blockHeight * 1 / 6);
            double yBottomRight = i * blockHeight + (blockHeight * 5 / 6);
            for (int j = 0; j < board[i].length; j++) {
                double xTopLeft = j * blockWidth + (blockWidth * 1 / 6);
                double xBottomRight = j * blockWidth + (blockWidth * 5 / 6);
                switch (board[i][j]) {
                    case O -> gc.strokeOval(xTopLeft, yTopLeft, blockWidth * 2 / 3, blockHeight * 2 / 3);
                    case X -> {
                        gc.strokeLine(xTopLeft, yTopLeft, xBottomRight, yBottomRight);
                        gc.strokeLine(xTopLeft, yBottomRight, xBottomRight, yTopLeft);
                    }
                }
            }
        }
    }
}
