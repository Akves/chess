import java.util.Scanner;

public class ChessBoard {
    Position[][] board = new Position[8][8];
    boolean currentPlayer = true;//true is white, false is black
    String gameStatus = "playing"; // playing. end, draw

    public String getGameStatus() {
        return gameStatus;
    }
    public boolean isInRange(int row_beg,
                             int column_beg,
                             int row_end,
                             int column_end){
        if(row_beg<0 || row_beg>7) return false;
        if(row_end<0 || row_end>7) return false;
        if(column_beg<0 || column_beg>7) return false;
        if(column_end<0 || column_end>7) return false;
        return true;
    }

    public ChessBoard() {
        for (int column = 0; column < 8; column++) {
            board[6][column] = new Position(6, column, new Pawn(false, '♟'));
            board[1][column] = new Position(1, column, new Pawn(true, '♙'));
            for (int x = 2; x < 6; x++) {
                board[x][column] = new Position(x, column, new Blank());
            }
        }

        board[0][0] = new Position(0, 0, new Rook(true, '♖'));
        board[0][7] = new Position(0, 7, new Rook(true, '♖'));
        board[7][0] = new Position(7, 0, new Rook(false, '♜'));
        board[7][7] = new Position(7, 7, new Rook(false, '♜'));

        board[0][1] = new Position(0, 1, new Knight(true, '♘'));
        board[0][6] = new Position(0, 6, new Knight(true, '♘'));
        board[7][1] = new Position(7, 1, new Knight(false, '♞'));
        board[7][6] = new Position(7, 6, new Knight(false, '♞'));

        board[0][2] = new Position(0, 2, new Bishop(true, '♗'));
        board[0][5] = new Position(0, 5, new Bishop(true, '♗'));
        board[7][2] = new Position(7, 2, new Bishop(false, '♝'));
        board[7][5] = new Position(7, 5, new Bishop(false, '♝'));

        board[0][3] = new Position(0, 3, new Queen(true, '♕'));
        board[7][4] = new Position(7, 4, new Queen(false, '♛'));

        board[0][4] = new Position(0, 4, new King(true, '♔'));
        board[7][3] = new Position(7, 3, new King(false, '♚'));
    }



    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        //visuals, updating and making moves
        while (getGameStatus().equals("playing")) {

            System.out.println("  |\u20031 | 2\u2003|\u20033 | 4\u2003|\u20035 | 6\u2003|\u20037 | 8\u2003|");
            for (int x = 0; x < 8; x++) {
                System.out.println("——+—―—+—―—+—―—+—―—+—―—+—―—+—―—+—―—+");
                System.out.print(x + 1 + " ");
                for (int y = 0; y < 8; y++) {
                    System.out.print("| " + board[x][y].piece.icon + " ");
                }
                System.out.println("|");
            }
            System.out.println("——+—―—+—―—+—―—+—―—+—―—+—―—+—―—+—―—+");
            int row_beg = -1;
            int columny_beg = -1;
            int row_end = -1;
            int column_end = -1;
            do{
            if (currentPlayer) {
                System.out.println("Ruch bialego gracza");
            } else System.out.println("Ruch czarnego gracza");

            System.out.println("Podaj wspolrzedne poczatku");
            System.out.print("y: ");
            row_beg = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.print("x: ");
            columny_beg = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.println("Podaj wspolrzedne konca");
            System.out.print("y: ");
            row_end = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.print("x: ");
            column_end = Integer.parseInt(scanner.nextLine()) - 1;
        }while (!isInRange(row_beg, columny_beg, row_end, column_end));

        result = board[row_beg][columny_beg].piece.isMovePossible(row_beg, columny_beg, row_end, column_end, board, currentPlayer);

        if (result) {
            System.out.println("ruch jest mozliwy");
            currentPlayer = !currentPlayer;
        } else {
            System.out.println("ruch nie jest mozliwy");
        }
        System.out.println("koniec tury");
        }

        }
}
