interface Pieces{

    public boolean isMovePossible(Position beginning, Position end, Position[][] board, boolean currentPlayer);
    default boolean isPositionAvailable(Position beginning, Position end, Position[][] board){
        boolean result = false;

        if (board[end.x][end.y].piece.icon == '\u2003'){
            result = true;
        }else if(board[beginning.x][beginning.y].piece.colour != board[end.x][end.y].piece.colour){
            result = true;
        }
        return result;
    };
    public boolean getColour();
}

