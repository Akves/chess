interface Pieces{

    public boolean isMovePossible(int row_beg, int column_beg, int row_end, int column_end, Position[][] board, boolean currentPlayer);
    default boolean isPositionAvailable(int row_beg, int column_beg, int row_end, int column_end, Position[][] board){
        boolean result = false;



        if (board[row_end][column_end].piece.icon == '\u2003'){
            result = true;
        }else if(board[row_beg][column_beg].piece.colour == board[row_end][column_end].piece.colour){
            result = true;
        }
        return result;
    };
    public boolean getColour();
}

