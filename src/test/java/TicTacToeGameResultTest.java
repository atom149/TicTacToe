import org.example.Board;
import org.example.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameResultTest {
    private TicTacToe game;
    private Board board;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        board = game.getBoard();
    }

    @Test
    void noWinnerOnEmptyBoard() {
        assertFalse(game.hasWinner());
    }

    @Test
    void detectRowWin() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void detectColumnWin() {
        board.place(0, 0, 'X');
        board.place(1, 0, 'X');
        board.place(2, 0, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void detectDiagonalWin() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void detectAntiDiagonalWin() {
        board.place(0, 2, 'X');
        board.place(1, 1, 'X');
        board.place(2, 0, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void noWinForMixedRow() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        assertFalse(game.hasWinner());
    }

    @Test
    void switchCurrentPlayer() {
        char before = game.getCurrentPlayer().getMarker();
        game.switchCurrentPlayer();
        char after = game.getCurrentPlayer().getMarker();
        assertNotEquals(before, after);
    }

    @Test
    void switchBackToFirstPlayer() {
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }
}
