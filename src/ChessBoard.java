import java.util.Scanner;

public class ChessBoard {
    Position[][] board = new Position[8][8];
    boolean currentPlayer = true;//true is white, false is black
    String gameStatus = "playing"; // playing. end, draw

    public String getGameStatus() {
        return gameStatus;
    }
    public boolean isInRange(Position beginning, Position end){
        if(beginning.x<0 || beginning.x>7) return false;
        if(beginning.y<0 || beginning.y>7) return false;
        if(end.x<0 || end.x>7) return false;
        if(end.y<0 || end.y>7) return false;
        return true;
    }

    public ChessBoard() {
        for (int column = 0; column < 8; column++) {
            /*board[6][column] = new Position(6, column, new Pawn(false, '♟'));
            board[1][column] = new Position(1, column, new Pawn(true, '♙'));*/
            board[6][column] = new Position(6, column, new Blank());
            board[1][column] = new Position(1, column, new Blank());
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
        board[7][3] = new Position(7, 3, new Queen(false, '♛'));

        board[0][4] = new Position(0, 4, new King(true, '♔'));
        board[7][4] = new Position(7, 4, new King(false, '♚'));
    }



    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean result;
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

            Position beginning = new Position(-1,-1);
            Position end = new Position(-1,-1);
            do{
            if (currentPlayer) {
                System.out.println("Ruch bialego gracza");
            } else System.out.println("Ruch czarnego gracza");

            System.out.println("Podaj wspolrzedne poczatku");
            System.out.print("kolumna: ");
            beginning.y = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.print("rzad: ");
            beginning.x = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.println("Podaj wspolrzedne konca");
            System.out.print("kolumna: ");
            end.y = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.print("rzad: ");
            end.x = Integer.parseInt(scanner.nextLine()) - 1;
        }while (!isInRange(beginning,end));

        result = board[beginning.x][beginning.y].piece.isMovePossible(beginning, end, board, currentPlayer);

        if (result) {
            System.out.println("ruch jest mozliwy");
            //currentPlayer = !currentPlayer;
        } else {
            System.out.println("ruch nie jest mozliwy");
        }
        System.out.println("koniec tury");
        }

        }
}
