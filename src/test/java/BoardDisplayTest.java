import org.example.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardDisplayTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void boardIsNotFullInitially() {
        assertFalse(board.isFull());
    }

    @Test
    void boardIsFullWhenAllCellsFilled() {
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                board.place(x, y, 'X');
        assertTrue(board.isFull());
    }

    @Test
    void boardIsNotFullWithOneEmptyCell() {
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                board.place(x, y, 'X');
        board.clear();
        assertFalse(board.isFull());
    }

    @Test
    void boardNotFullAfterSomeMoves() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        assertFalse(board.isFull());
    }
}
