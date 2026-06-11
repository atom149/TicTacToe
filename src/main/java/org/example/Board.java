public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public void clear() {
        for (char[] row : cells)
            java.util.Arrays.fill(row, '-');
    }

    public char[][] getCells() {
        return cells;
    }

    // NEU: US1 - make-a-move
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '-';
    }

    // NEU: US1 - make-a-move
    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }
}
