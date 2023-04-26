public class Knight extends PiecesAbstract{

public Knight(boolean colour, char icon){
    this.colour = colour;
    status = true;
    this.icon = icon;
}
@Override
public boolean isMovePossible(int row_beg,
                              int column_beg,
                              int row_end,
                              int column_end,
                              Position[][] board,
                              boolean currentPlayer) {
    System.out.println("row_beg: " + row_beg + " | column_beg:" + column_beg);
    System.out.println("row_end:" + row_end + " | column_end:" + column_end);
    System.out.println(board[row_beg][column_beg].piece.icon);

//      currentPlayer true is white, false is black
//      colour true is white, false is black

    boolean result = false;
    /*if(board[row_beg][column_beg].piece.colour == board[row_end][column_end].piece.colour){
        return result;
    }*/
   /* if ( !isPositionAvailable(int row_beg,
    int column_beg,
    int row_end,
    int column_end,
    Position[][] board,
    boolean currentPlayer) )return false; */

    System.out.println("colour_beg: "+ board[row_beg][column_beg].piece.colour);
    System.out.println("colour_end: "+ board[row_end][column_end].piece.colour);
    int columnDiff;
    int rowDiff;
    columnDiff = Math.abs(column_beg-column_end);
    rowDiff = Math.abs(row_beg-row_end);
    boolean isPositionAvailable = isPositionAvailable(row_beg, column_beg, row_end, column_end, board);

    if(!isPositionAvailable)return false;
        if (currentPlayer == this.colour) {
                if (columnDiff == 1 && rowDiff == 2)result = true;
                else if(columnDiff == 2 && rowDiff ==1)result = true;
        }



    if (result) {
        board[row_end][column_end] = board[row_beg][column_beg];
        board[row_beg][column_beg] = new Position(row_beg, column_beg, new Blank());
    }
    return result;
}

public boolean getColour(){
    return colour;
}
}
