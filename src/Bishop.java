public class Bishop extends PiecesAbstract{

    public Bishop(boolean colour, char icon){
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
            while( !temp.equals(end) ){
                if (temp.x < end.x) temp.x++;
                else temp.x--;

                if (temp.y < end.y) temp.y++;
                else temp.y--;

                if(isPositionAvailable(beginning, temp, board)){
                    continue;
                }
                else{
                   return result;
                }
            }
            result = true;
        }

        if (result) {
            board[end.x][end.y].piece.status = false;
            board[end.x][end.y] = board[beginning.x][beginning.y];
            board[beginning.x][beginning.y] = new Position(beginning.x, beginning.y, new Blank());
        }
        return result;
    }

    public boolean getColour(){
        return colour;
    }
}
