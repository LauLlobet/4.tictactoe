public class Tictactoe {

    Mark currentPlayer = Mark.X;
    private Board board;
    private Mark winner = Mark.empty;

    public Tictactoe(Board board) {
        this.board = board;
    }

    public Mark currentPlayerMark() {
        return currentPlayer;
    }

    public void playTurn(Row row, Column column) throws Exception{
        board.placeMarkOrThrow(currentPlayer,row,column);
        setWinnerIfWon(currentPlayer,row,column);
        currentPlayer = nextPlayer();
    }

    private Mark nextPlayer(){
        if(currentPlayer == Mark.X){
            return Mark.O;
        }
        return Mark.X;
    }

    public boolean hasEnded() {
        return winner != Mark.empty || board.isFull();
    }

    public Mark getWinner() {
        return winner;
    }

    private void setWinnerIfWon(Mark x, Row row, Column column) {
        if(board.hasThreeInARow(x))
            winner = x;
        }
    }

