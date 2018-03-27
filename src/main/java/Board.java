import java.util.Arrays;
import java.util.Vector;

public class Board {

    Vector<Mark> boardVector = new Vector<>(Arrays.asList(Mark.empty, Mark.empty, Mark.empty,
            Mark.empty, Mark.empty, Mark.empty,
            Mark.empty, Mark.empty, Mark.empty));


    public void placeMarkOrThrow(Mark playerMark, Row row, Column column) throws Exception {
        if (getMark(row, column) != playerMark.empty) {
            throw new Exception("trying to play on a full cell");
        }
        setMark(playerMark, row, column);
    }

    private void setMark(Mark playerMark, Row row, Column column) {
        boardVector.set(getIndex(row, column), playerMark);
    }

    private int getIndex(Row row, Column column) {
        return row.getIndex() * 3 + column.getIndex();
    }

    private Mark getMark(Row row, Column column) {
        return boardVector.get(getIndex(row, column));
    }

    public boolean isFull() {
        return boardVector.stream().filter(x -> x != Mark.empty).count() == 9;
    }

    public boolean hasThreeInARow(Mark x) {
        if(     getMark(Row.UP, Column.LEFT) == x &&
                getMark(Row.MIDDLE, Column.LEFT) == x &&
                getMark(Row.DOWN, Column.LEFT) == x)
            return true;
        if(     getMark(Row.UP, Column.MIDDLE) == x &&
                getMark(Row.MIDDLE, Column.MIDDLE) == x &&
                getMark(Row.DOWN, Column.MIDDLE) == x)
            return true;
        if(     getMark(Row.UP, Column.RIGHT) == x &&
                getMark(Row.MIDDLE, Column.RIGHT) == x &&
                getMark(Row.DOWN, Column.RIGHT) == x)
            return true;
        if(     getMark(Row.UP, Column.LEFT) == x &&
                getMark(Row.UP, Column.MIDDLE) == x &&
                getMark(Row.UP, Column.RIGHT) == x)
            return true;
        if(     getMark(Row.MIDDLE, Column.LEFT) == x &&
                getMark(Row.MIDDLE, Column.MIDDLE) == x &&
                getMark(Row.MIDDLE, Column.RIGHT) == x)
            return true;
        if(     getMark(Row.DOWN, Column.LEFT) == x &&
                getMark(Row.DOWN, Column.MIDDLE) == x &&
                getMark(Row.DOWN, Column.RIGHT) == x)
            return true;
        if(     getMark(Row.UP, Column.LEFT) == x &&
                getMark(Row.MIDDLE, Column.MIDDLE) == x &&
                getMark(Row.DOWN, Column.RIGHT) == x)
            return true;
        return false;
    }

}
