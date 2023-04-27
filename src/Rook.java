public class Rook extends PiecesAbstract{

    public Rook(boolean colour, char icon){
        this.colour = colour;
        status = true;
        this.icon = icon;
    }
    @Override
    public boolean isMovePossible(Position beginning, Position end, Position[][] board, boolean currentPlayer) {
        System.out.println("row_beg: " + beginning.x + " | column_beg:" + beginning.y);
        System.out.println("row_end:" + end.x + " | column_end:" + end.y);
        System.out.println(board[beginning.x][beginning.y].piece.icon);

        boolean result = false;
        boolean isPositionAvailable = isPositionAvailable(beginning, end, board);

        if(!isPositionAvailable) return false;

        Position temp = new Position(beginning.x, beginning.y);

        if (currentPlayer == this.colour) {
            if(beginning.x == end.x){
                while( !temp.equals(end) ){
                    if (temp.y < end.y) temp.y++;
                    else temp.y--;
                    if( !isPositionAvailable(beginning, temp, board) ) return result;
                }
            }else if (beginning.y == end.y) {
                while( !temp.equals(end) ){
                    if (temp.x < end.x) temp.x++;
                    else temp.x--;
                    if( !isPositionAvailable(beginning, temp, board) ) return result;
                }
            }else return result;
            result = true;
        }

        capture(result, beginning, end, board);
        return result;
    }



    public boolean getColour(){
        return colour;
    }
}
