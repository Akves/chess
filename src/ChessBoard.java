import java.util.*;

public class ChessBoard {
    Position[][] board;
    boolean currentPlayer; // true is white, false is black;
    String gameStatus; // playing. end, draw
    Position whiteKingPosition;
    Position blackKingPosition;

    public String getGameStatus() {
        return gameStatus;
    }
    public boolean isInRange(Position beginning, Position end){
        if(beginning.x<0 || beginning.x>7) return false;
        if(beginning.y<0 || beginning.y>7) return false;
        if(end.x<0 || end.x>7) return false;
        if(end.y<0 || end.y>7) return false;
        return true;
    }public boolean isInRange(int number){
        if(number<0 || number>7) return false;
        return true;
    }

    public List<Integer> isListUnique(List<Integer> input) {
        List<Integer> outputList = new ArrayList<>();
        if (input.isEmpty()) return outputList;

        if (outputList.isEmpty()) {
            outputList.add(input.get(0));
            outputList.add(input.get(1));
        }
        for (int i = 2; i < input.size(); i += 2) {
            int input_x = input.get(i);
            int input_y = input.get(i + 1);
            boolean contains = false;
            for (int j = 0; j < outputList.size(); j += 2) {
                int outputList_x = outputList.get(j);
                int outputList_y = outputList.get(j + 1);

                if (input_x == outputList_x && input_y == outputList_y) {
                    contains = true;
                    break;
                }
            }
            if (!contains){
                outputList.add(input_x);
                outputList.add(input_y);
            }
        }
        return outputList;
    }

    public List<Integer> kingSurroundings(){
        List<Integer> kingSurroundings = new ArrayList<>(9);
            if (currentPlayer){
                for (int x = -1; x < 2; x++) {
                    if (isInRange(whiteKingPosition.x + x)) {
                        for (int y = -1; y < 2; y++) {
                            if (isInRange(whiteKingPosition.y + y)) {
                                kingSurroundings.add(whiteKingPosition.x + x);
                                kingSurroundings.add(whiteKingPosition.y + y);
                            }
                        }
                    }
                }
            }else{
                for (int x = -1; x < 2; x++) {
                    if ( isInRange(blackKingPosition.x +x) ){
                        for (int y = -1; y < 2; y++) {
                            if ( isInRange(blackKingPosition.y +y) ){
                                kingSurroundings.add(blackKingPosition.x + x);
                                kingSurroundings.add(blackKingPosition.y + y);
                            }
                        }
                    }
                }
            }
        //System.out.println("otoczenie: " + kingSurroundings);
        return kingSurroundings;
    }
    public List<Integer>  kingInDanger(){
        List<Integer> list = new ArrayList<>();

        boolean tempCurrentPlayer = !currentPlayer;
        List<Integer> kingSurroundings = kingSurroundings();
        Position temp = new Position(-1,-1);//temporary position used to compare pieces with king surroundings

            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    for (int i=0; i< kingSurroundings.size(); i+=2){
                        if (board[x][y].piece.icon == '\u2003') {
                            break;
                        }else if (board[x][y].piece.colour != currentPlayer ){
                            temp.x = kingSurroundings.get(i);
                            temp.y = kingSurroundings.get(i+1);
                            //System.out.println("checking " + temp.x + " | " + temp.y);
                            boolean result = board[x][y].piece.isMovePossible(board[x][y], temp, board, tempCurrentPlayer);
                            //System.out.println(board[x][y].piece.icon + " - " + x + " | " + y + " =>" + temp.x + " | " + temp.y);
                            if (result){
                                //System.out.println(board[x][y].piece.icon + " - " + x + " | " + y + " =>" + temp.x + " | " + temp.y);
                                board[x][y].piece.isMovePossible(board[x][y], temp, board, tempCurrentPlayer);
                                list.add(temp.x);
                                list.add(temp.y);
                            }
                        }
                    }
                }
            }
        //System.out.println("lista zagrozonych pol" + list);

        List<Integer>  output = isListUnique(list);
        //System.out.println("lista bez powielen"+output);

        return output;
    }

    public void createBoard(){
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

    public ChessBoard() {
        currentPlayer = true;//true is white, false is black
        board = new Position[8][8];
        gameStatus = "playing"; // playing. end, draw
        createBoard();
        whiteKingPosition = new Position(0,4);
        blackKingPosition = new Position(7,4);
    }

    //if piece can move and on position is an enemy piece or blank space => move your piece
    public void capture(Position beginning, Position end) {
        board[end.x][end.y].piece.status = false;
        board[end.x][end.y] = board[beginning.x][beginning.y];
        board[beginning.x][beginning.y] = new Position(beginning.x, beginning.y, new Blank());

        if (end.piece instanceof King) gameStatus = "end";
    }

    public void clearScreen(){
        System.out.println(new String(new char[10]).replace("\0", "\r\n"));
    };

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean result;
        while (getGameStatus().equals("playing")) {
            {
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
            }//printing the board and pieces
            Position beginning = new Position(-1,-1);
            Position end = new Position(-1,-1);

            boolean isKingSafe;
            do{
                isKingSafe = true;
                if (currentPlayer) {
                    System.out.println("Ruch bialego gracza");
                } else System.out.println("Ruch czarnego gracza");

                List <Integer> kingInDanger = kingInDanger();
                System.out.println("Krol jest zagrozony na polach:");

                for (int i =0; i<kingInDanger.size(); i+=2 ){
                    int x = kingInDanger.get(i)+1;
                    int y = kingInDanger.get(i+1)+1;
                    System.out.println("[ " + x + " | " + y + " ]");
                }

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

                if(board[beginning.x][beginning.y].piece instanceof King){

                    for (int i =0; i<kingInDanger.size(); i+=2 ){
                        //System.out.println(" - " + end.x + " | " + end.y + " =" + kingInDanger.get(i) + " | " + kingInDanger.get(i+1));
                        if (end.x == kingInDanger.get(i) && end.y == kingInDanger.get(i+1)){
                            System.out.println("To pole jest atakowane!!!");
                            isKingSafe = false;
                            break;
                        }else isKingSafe = true;
                    }
                }
            }while ( !(isInRange(beginning,end) && isKingSafe) );


            //main action, checking if piece can move
            result = board[beginning.x][beginning.y].piece.isMovePossible(beginning, end, board, currentPlayer);

            if (result) {
                capture(beginning, end);//move piece
                System.out.println("ruch jest mozliwy");


                clearScreen();

                //is moved piece was king update his position
                if(board[end.x][end.y].piece instanceof King){
                    if (currentPlayer){
                        whiteKingPosition.x = end.x;
                        whiteKingPosition.y = end.y;
                    }else{
                        blackKingPosition.x = end.x;
                        blackKingPosition.y = end.y;
                    }
                }

                //if king can be captured in next turn print info about it
                if (currentPlayer){
                    if (board[end.x][end.y].piece.isMovePossible(
                            end,
                            board[blackKingPosition.x][blackKingPosition.y],
                            board,
                            currentPlayer)) {
                        System.out.println("!!!szach!!!");
                    }
                }else {
                    if (board[end.x][end.y].piece.isMovePossible(
                            end,
                            board[whiteKingPosition.x][whiteKingPosition.y],
                            board,
                            currentPlayer)) {
                        System.out.println("!!!szach!!!");
                    }
                }
                currentPlayer = !currentPlayer;//changing state of current player
            } else {
                clearScreen();
                System.out.println("ruch nie jest mozliwy");
            }
        }

    }
}