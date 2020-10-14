package model;

public class Game {
    private final char[][] board = new char[3][3];
    private char turn;
    private int move;
    int xWinCount = 0;
    int oWinCount = 0;

// restart the game
    public void restart() {
        this.turn = 'x';
        this.move = 0;
    }

    public char nextTurn(int i, int j) {
        if (board[i][j] != 0) {
            return 'f';
        }
        board[i][j] = turn;
        move++;
        char result = whoWin(i, j);
        if (result != 0) {
            return result;
        }
        switch (turn) {
            case 'x' -> {
                turn = 'o';
            }
            case 'o' -> {
                turn = 'x';
            }
        }
        return result;
    }
// win codition
    public char whoWin(int i, int j) {
        //check column
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] != turn) {
                break;
            }
            if (k == board.length - 1) {
                return turn;
            }
        }
        //check row
        for (int k = 0; k < board[i].length; k++) {
            if (board[i][k] != turn) {
                break;
            }
            if (k == board.length - 1) {
                return turn;
            }
        }
        //check diag
        if (i == j) {
            for (int k = 0; k < board.length; k++) {
                if (board[k][k] != turn) {
                    break;
                }
                if (k == board.length - 1) {
                    return turn;
                }
            }
        }
        //check anti-diag
        if (i + j == board.length - 1) {
            for (int k = 0; k < board.length; k++) {
                if (board[k][(board.length - 1) - k] != turn) {
                    break;
                }
                if (k == board.length - 1) {
                    return turn;
                }
            }
        }
        //check draw
        if (move == 9) {
            return 'd';
        }
        return 0;
    }
// clear board array
    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public char[][] getBoard() {
        return this.board;
    }

    public int getOWinCount() {
        return oWinCount;
    }

    public int getXWinCount() {
        return xWinCount;
    }

    public void addOWinCount() {
        this.oWinCount = oWinCount + 1;
    }

    public void addXWinCount() {
        this.xWinCount = xWinCount + 1;
    }
}
