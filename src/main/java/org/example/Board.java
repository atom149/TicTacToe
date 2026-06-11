package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public void clear() {
        for (char[] row : cells)
            java.util.Arrays.fill(row, ' ');
    }

    public char[][] getCells() {
        return cells;
    }
}
