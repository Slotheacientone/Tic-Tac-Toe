package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class View {
    private final GraphicsContext gc;
    private final double blockWidth;
    private final double blockHeight;

    public View(GraphicsContext gc, double blockWidth, double blockHeight) {
        this.gc = gc;
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
    }

    public void repaint(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            double yTopLeft = i * blockHeight + (blockHeight * 1 / 6);
            double yBottomRight = i * blockHeight + (blockHeight * 5 / 6);
            for (int j = 0; j < board[i].length; j++) {
                double xTopLeft = j * blockWidth + (blockWidth * 1 / 6);
                double xBottomRight = j * blockWidth + (blockWidth * 5 / 6);
                switch (board[i][j]) {
                    case 'o' -> gc.strokeOval(xTopLeft, yTopLeft, blockWidth * 2 / 3, blockHeight * 2 / 3);
                    case 'x' -> {
                        gc.strokeLine(xTopLeft, yTopLeft, xBottomRight, yBottomRight);
                        gc.strokeLine(xTopLeft, yBottomRight, xBottomRight, yTopLeft);
                    }
                }
            }
        }
    }

    // draw the board
    public void drawBoard() {
        double width = blockWidth * 3;
        double height = blockHeight * 3;
        gc.clearRect(0, 0, width, height);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        // Draw board
        gc.strokeLine(blockWidth, 0, blockWidth, height);
        gc.strokeLine(blockWidth * 2, 0, blockWidth * 2, height);
        gc.strokeLine(0, blockHeight, width, blockHeight);
        gc.strokeLine(0, blockHeight * 2, width, blockHeight * 2);
    }
}
