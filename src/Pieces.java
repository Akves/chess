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

    default boolean capture(boolean result, Position beginning, Position end, Position[][] board) {
        if(!result) return false;
        board[end.x][end.y].piece.status = false;
        board[end.x][end.y] = board[beginning.x][beginning.y];
        board[beginning.x][beginning.y] = new Position(beginning.x, beginning.y, new Blank());
        return true;
    }

    public boolean getColour();
}

