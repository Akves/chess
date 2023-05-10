public class Pawn extends PiecesAbstract{

    public Pawn(boolean colour, char icon){
        this.colour = colour;
        status = true;
        this.icon = icon;
    }

    @Override
    public boolean isMovePossible(Position beginning, Position end, Position[][] board, boolean currentPlayer) {

//      currentPlayer true is white, false is black
//      colour true is white, false is black

        boolean result = false;
        boolean isPositionAvailable = isPositionAvailable(beginning, end, board);

        if(!isPositionAvailable) return false;

        if (currentPlayer == this.colour) {
            if (this.colour) {
                if (beginning.y == end.y) {
                    if ( (beginning.x != 1) && (beginning.x + 1)== end.x ) {
                        result = true;
                    } else if ((beginning.x + 2) == end.x || beginning.x + 1 == end.x) {
                        result = true;
                    }
                }
                if ( Math.abs(beginning.y- end.y)==1 && (beginning.x+1)==end.x) result = true;
            } else {
                if (beginning.y == end.y) {
                    if (beginning.x != 6) {
                        if (beginning.x - 1 == end.x) {
                            result = true;
                        }
                    } else if (beginning.x - 2 == end.x || beginning.x - 1 == end.x) {
                        result = true;
                    }
                }
                if ( Math.abs(beginning.y- end.y)==1 && (beginning.x-1)==end.x) result = true;
            }
        }
        return result;
    }

    public boolean getColour(){
        return colour;
    }
}
