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

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (char[] row : cells)
            for (char c : row)
                if (c == ' ') return false;
        return true;
    }

    public void print() {
        System.out.println("  0 1 2");
        System.out.println(" ▁▁▁▁▁▁▁");
        for (int x = 0; x < 3; x++) {
            System.out.print(x + "|");
            for (int y = 0; y < 3; y++) {
                System.out.print(cells[x][y] + "|");
            }
            System.out.println();
        }
        System.out.println(" ▔▔▔▔▔▔▔");
    }
}
