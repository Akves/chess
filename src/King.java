public class King extends PiecesAbstract{

    public King(boolean colour, char icon){
        this.colour = colour;
        status = true;
        this.icon = icon;
    }

    @Override
    public boolean isMovePossible(Position beginning, Position end, Position[][] board, boolean currentPlayer) {
        boolean result = false;
        int columnDiff;
        int rowDiff;

        columnDiff = Math.abs(beginning.x-end.x);
        rowDiff = Math.abs(beginning.y-end.y);
        boolean isPositionAvailable = isPositionAvailable(beginning, end, board);

        if(!isPositionAvailable) return false;

        if (currentPlayer == this.colour) {
            if (columnDiff == 1){
                if(rowDiff == 0 || rowDiff == 1) result = true;
            } else if (rowDiff == 1){
                if(columnDiff == 0) result = true;
            }
        }
        return result;
    }

    public boolean getColour(){
        return colour;
    }
}
