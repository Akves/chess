public class Rook extends PiecesAbstract{

    public Rook(boolean colour, char icon){
        this.colour = colour;
        status = true;
        this.icon = icon;
    }
    @Override
    public boolean isMovePossible(Position beginning, Position end, Position[][] board, boolean currentPlayer) {
        return false;
    }


    public boolean getColour(){
        return colour;
    }
}
