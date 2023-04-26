import java.util.Scanner;

public class Menu {
    public void play(){
        ChessBoard board = new ChessBoard();
        board.start();
    }

    public void chooseGamemode(){
        System.out.println("choosegamemode");
    }
    public void addPlayer(){
        System.out.println("addPlayer");
    }

    public  void start(){
        String end = "4";
        String[] options = {
                "Play",
                "Gamemode",
                "Add second player",
        };
        play();
        Scanner scanner = new Scanner(System.in);

        String choice = "";
        while(!choice.equals(end)){

            PrintOptions.printOptions(options);
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> play();
                case "2" -> chooseGamemode();
                case "3" -> addPlayer();
                default -> System.out.println("--END MENU--");
            }
        }

    }

}
