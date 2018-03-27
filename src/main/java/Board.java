import java.util.Arrays;
import java.util.Vector;

public class Board {

    Vector<Mark> boardVector = new Vector<>(Arrays.asList(Mark.empty, Mark.empty, Mark.empty,
            Mark.empty, Mark.empty, Mark.empty,
            Mark.empty, Mark.empty, Mark.empty));

    public void placeMarkOrThrow(Mark playerMark, int row, int column) throws Exception {

        if (getMark(row, column) != playerMark.empty) {
            throw new Exception("trying to play on a full cell");
        }
        setMark(playerMark, row, column);
    }

    private void setMark(Mark playerMark, int row, int column) {
        boardVector.set(row * 3 + column, playerMark);
    }

    private Mark getMark(int row, int column) {
        return boardVector.get(row * 3 + column);
    }

    boolean hasSameMarkInRange(Mark mark, int initX, int endX, int intitY, int endY) {
        for (int x = initX; x <= endX; x++) {
            for (int y = intitY; y <= endY; y++) {
                if (getMark(x, y) != mark) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFull() {
        return boardVector.stream().map(x -> x != Mark.empty).reduce(true, (x, y) -> x && y);
    }

    public boolean hasSameMarkInRow(Mark x, int row) {
        return hasSameMarkInRange(x,row,row,0,2);
    }

    public boolean hasSameMarkInColumn(Mark x, int column) {
        return  hasSameMarkInRange(x, 0, 2, column, column);
    }
}
