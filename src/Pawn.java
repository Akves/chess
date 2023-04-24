public class Pawn extends PiecesAbstract{

    public Pawn(boolean colour, char icon){
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
        if (currentPlayer == this.colour) {
            if (this.colour) {
                if (column_beg == column_end) {
                    if (row_beg != 1) {
                        if ((row_beg + 1) == row_end) {
                            result = true;
                        }
                    } else if ((row_beg + 2) == row_end || row_beg + 1 == row_end) {
                        result = true;
                    }
                }
            } else {
                if (column_beg == column_end) {
                    if (row_beg != 6) {
                        if (row_beg - 1 == row_end) {
                            result = true;
                        }
                    } else if (row_beg - 2 == row_end || row_beg - 1 == row_end) {
                        result = true;
                    }
                }
            }
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
