public class Knight extends PiecesAbstract{

public Knight(boolean colour, char icon){
    this.colour = colour;
    status = true;
    this.icon = icon;
}
@Override
public boolean isMovePossible(Position beginning, Position end, Position[][] board, boolean currentPlayer) {

//      currentPlayer true is white, false is black
//      colour true is white, false is black

    boolean result = false;
    int columnDiff;
    int rowDiff;

    columnDiff = Math.abs(beginning.x-end.x);
    rowDiff = Math.abs(beginning.y-end.y);
    boolean isPositionAvailable = isPositionAvailable(beginning, end, board);

    if(!isPositionAvailable) return false;

    if (currentPlayer == this.colour) {
            if (columnDiff == 1 && rowDiff == 2)result = true;
            else if(columnDiff == 2 && rowDiff ==1)result = true;
    }

    capture(result, beginning, end, board);
    return result;
}

public boolean getColour(){
    return colour;
}
}
