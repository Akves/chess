public class Blank extends PiecesAbstract{

    public Blank(){
        this.icon = '\u2003';
    }
    @Override
    public boolean isMovePossible(int row_beg, int column_beg, int row_end, int column_end, Position[][] board, boolean currentPlayer) {
        return false;
    }

    public boolean getColour(){
        return colour;
    }
}
