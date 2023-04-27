public class Bishop extends PiecesAbstract{

    public Bishop(boolean colour, char icon){
        this.colour = colour;
        status = true;
        this.icon = icon;
    }
    @Override
    public boolean isMovePossible(Position beginning, Position end, Position[][] board, boolean currentPlayer) {
        boolean result = false;
        boolean isPositionAvailable = isPositionAvailable(beginning, end, board);

        if(!isPositionAvailable) return false;

        Position temp = new Position(beginning.x, beginning.y);
        int columnDiff;
        int rowDiff;

        columnDiff = Math.abs(beginning.x-end.x);
        rowDiff = Math.abs(beginning.y-end.y);
        if (currentPlayer == this.colour) {
            if (columnDiff == rowDiff){
                while( !temp.equals(end) ){
                    if (temp.x < end.x) temp.x++;
                    else temp.x--;
                    if (temp.y < end.y) temp.y++;
                    else temp.y--;

                    if( !isPositionAvailable(beginning, temp, board) ) return result;
                }
            }
            result = true;
        }

        capture(result, beginning, end, board);
        return result;
    }
    public boolean getColour(){
        return colour;
    }
}
