public class Bishop extends PiecesAbstract{

    public Bishop(boolean colour, char icon){
        this.colour = colour;
        status = true;
        this.icon = icon;
    }
    @Override
    public boolean isMovePossible(int row_beg, int column_beg, int row_end, int column_end, Position[][] board, boolean currentPlayer) {
        return false;
    }

    public boolean getColour(){
        return colour;
    }
}
