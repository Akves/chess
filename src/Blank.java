public class Blank extends PiecesAbstract{

    public Blank(){
        this.icon = '\u2003';
    }
    @Override
    public boolean isMovePossible(Position beginning, Position end, Position[][] board, boolean currentPlayer) {
        return false;
    }

    public boolean getColour(){
        return colour;
    }
}
