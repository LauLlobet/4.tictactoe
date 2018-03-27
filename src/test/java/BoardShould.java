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
        board.placeMarkOrThrow(Mark.X, Row.UP, Column.LEFT);
        board.placeMarkOrThrow(Mark.X, Row.UP, Column.LEFT);
    }

    @Test
    public void be_not_full_if_still_has_empty_cells() throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, Row.UP, Column.LEFT);
        assertFalse(board.isFull());
        board.placeMarkOrThrow(Mark.X, Row.DOWN, Column.LEFT);
        assertFalse(board.isFull());
        board.placeMarkOrThrow(Mark.X, Row.UP, Column.MIDDLE);
        assertFalse(board.isFull());
        board.placeMarkOrThrow(Mark.X, Row.DOWN, Column.MIDDLE);
        assertFalse(board.isFull());
    }

    @Test
    public void tell_if_its_full() throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, Row.UP, Column.LEFT);
        board.placeMarkOrThrow(Mark.X, Row.UP, Column.MIDDLE);

        board.placeMarkOrThrow(Mark.X, Row.UP, Column.RIGHT);
        board.placeMarkOrThrow(Mark.X, Row.MIDDLE, Column.LEFT);

        board.placeMarkOrThrow(Mark.X, Row.MIDDLE, Column.MIDDLE);
        board.placeMarkOrThrow(Mark.X, Row.MIDDLE, Column.RIGHT);

        board.placeMarkOrThrow(Mark.X, Row.DOWN, Column.LEFT);
        board.placeMarkOrThrow(Mark.X, Row.DOWN, Column.MIDDLE);

        assertFalse(board.isFull());

        board.placeMarkOrThrow(Mark.X, Row.DOWN, Column.RIGHT);
        assertTrue(board.isFull());
    }

    @Test
    public void detect_a_row_of_same_mark() throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, Row.UP,Column.MIDDLE);
        board.placeMarkOrThrow(Mark.X, Row.UP, Column.RIGHT);

        assertFalse(board.hasThreeInARow(Mark.X));

        board.placeMarkOrThrow(Mark.X, Row.UP, Column.LEFT);

        assertTrue(board.hasThreeInARow(Mark.X));
    }


    @Test
    public void detect_a_colum_of_same_mark() throws Exception {
        Board board = new Board();
        board.placeMarkOrThrow(Mark.X, Row.DOWN, Column.LEFT);
        board.placeMarkOrThrow(Mark.X, Row.MIDDLE, Column.LEFT);

        assertFalse(board.hasThreeInARow(Mark.X));

        board.placeMarkOrThrow(Mark.X, Row.UP, Column.LEFT);

        assertTrue(board.hasThreeInARow(Mark.X));
    }
}
