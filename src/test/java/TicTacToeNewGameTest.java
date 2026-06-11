import org.example.Board;
import org.example.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeNewGameTest {
    private TicTacToe game;
    private Board board;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        board = game.getBoard();
    }

    @Test
    void resetClearsBoard() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        game.reset();
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    void resetSetsCurrentPlayerToX() {
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMarker());
        game.reset();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    void resetAllowsNewMoves() {
        board.place(0, 0, 'X');
        game.reset();
        board.place(0, 0, 'O');
        assertEquals('O', board.getCells()[0][0]);
    }

    @Test
    void boardIsEmptyAfterReset() {
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                board.place(x, y, 'X');
        game.reset();
        assertFalse(board.isFull());
    }
}
