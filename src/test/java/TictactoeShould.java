import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class TictactoeShould {

    /*
    Tic Tac Toe rules:
X_PLAYER_MARK always goes first.
Players alternate placing X_PLAYER_MARK’s and O_PLAYER_MARK’s on the board
Players cannot play on a played position
alternate until either:
    All nine squares are filled.
One player has three in a row, horizontally, vertically or diagonally
If a player is able to draw three X_PLAYER_MARK’s or three O_PLAYER_MARK’s in a row, that player wins.
If all nine squares are filled and neither player has three in a row, the game is a draw.
     */

    @Test
    public void start_with_player_x() {
        Tictactoe tictactoe = new Tictactoe(new Board());

        assertEquals(tictactoe.currentPlayerMark(), Mark.X);
    }

    @Test
    public void alternate_players_after_each_turn() throws Exception {
        Tictactoe tictactoe = new Tictactoe(new Board());

        tictactoe.playTurn(Row.UP, Column.MIDDLE);

        assertEquals(tictactoe.currentPlayerMark(), Mark.O);

        tictactoe.playTurn(Row.UP, Column.LEFT);

        assertEquals(tictactoe.currentPlayerMark(), Mark.X);
    }


}
