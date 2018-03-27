import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BoardShould {


    @Test(expected = Exception.class)
    public void prevent_from_playing_at_already_played_position() throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, 0, 0);
        board.placeMarkOrThrow(Mark.X, 0, 0);
    }

    @Test
    public void be_not_full_if_still_has_empty_cells() throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, 0, 0);
        assertFalse(board.isFull());
        board.placeMarkOrThrow(Mark.X, 2, 0);
        assertFalse(board.isFull());
        board.placeMarkOrThrow(Mark.X, 0, 1);
        assertFalse(board.isFull());
        board.placeMarkOrThrow(Mark.X, 2, 1);
        assertFalse(board.isFull());
    }

    @Test
    public void tell_if_its_full() throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, 0, 0);
        board.placeMarkOrThrow(Mark.X, 0, 1);

        board.placeMarkOrThrow(Mark.X, 0, 2);
        board.placeMarkOrThrow(Mark.X, 1, 0);

        board.placeMarkOrThrow(Mark.X, 1, 1);
        board.placeMarkOrThrow(Mark.X, 1, 2);

        board.placeMarkOrThrow(Mark.X, 2, 0);
        board.placeMarkOrThrow(Mark.X, 2, 1);

        assertFalse(board.isFull());

        board.placeMarkOrThrow(Mark.X, 2, 2);
        assertTrue(board.isFull());
    }

    @Test
    @Parameters({"0",
            "1",
            "2"
    })
    public void detect_a_row_of_same_mark(int row_winner) throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, row_winner, 0);
        board.placeMarkOrThrow(Mark.X, row_winner, 1);

        assertFalse(board.hasSameMarkInRow(Mark.X, row_winner));

        board.placeMarkOrThrow(Mark.X, row_winner, 2);

        assertTrue(board.hasSameMarkInRow(Mark.X, row_winner));
    }


    @Test
    @Parameters({"0",
            "1",
            "2"
    })
    public void detect_a_colum_of_same_mark(int column_winner) throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, 0, column_winner);
        board.placeMarkOrThrow(Mark.X, 1, column_winner);

        assertFalse(board.hasSameMarkInColumn(Mark.X,column_winner));

        board.placeMarkOrThrow(Mark.X, 2, column_winner);

        assertTrue(board.hasSameMarkInColumn(Mark.X,column_winner));
    }
}
