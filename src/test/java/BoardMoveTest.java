import org.example.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardMoveTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void cellIsEmptyInitially() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void cellIsNotEmptyAfterPlace() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void placesSetsCorrectMarker() {
        board.place(1, 2, 'O');
        assertEquals('O', board.getCells()[1][2]);
    }

    @Test
    void placeDoesNotAffectOtherCells() {
        board.place(0, 0, 'X');
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    void allCellsEmptyAfterClear() {
        board.place(0, 0, 'X');
        board.place(2, 2, 'O');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(2, 2));
    }
}
