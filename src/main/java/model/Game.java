package model;

import javafx.scene.canvas.GraphicsContext;
import view.View;

public class Game {
    public final static int X = 1;
    public final static int O = 2;
    public int[][] board = new int[3][3];
    public int turn=X;
    public View view ;
    public void start(View view) {
        this.view = view;
    }

    public void nextTurn(int i, int j) {
        board[i][j] = turn;
        switch (turn){
            case X -> turn=O;
            case O -> turn=X;
        }
        view.repaint(board);
    }
}
