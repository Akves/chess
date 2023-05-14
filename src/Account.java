import java.util.Scanner;

public class Account {

     private String userLogin;
    private  String userPassword;
    private String keyboardLogin;
    private String keyboardPassword;

    public Account(){
        userLogin = "1";
        userPassword = "1";
    }

    public  void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login: ");
         keyboardLogin = scanner.nextLine();

        System.out.println("Password: ");
         keyboardPassword = scanner.nextLine();
        if(keyboardLogin.equals(userLogin) && keyboardPassword.equals(userPassword)){
            System.out.println("zalogowano");
            Menu menu_instance = new Menu();
            menu_instance.start();
        }
        else System.out.println("Bledny login lub haslo");
    }

    public  void register(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("New login: ");
         userLogin = scanner.nextLine();

        System.out.println("New password: ");
         userPassword = scanner.nextLine();

        System.out.println("Account created!");
    }
    public  void start(){
        String end = "3";
        String[] options = {
                "Login",
                "Register",
        };
        Scanner scanner = new Scanner(System.in);

        String choice = "";
        while(!choice.equals(end)) {
            PrintOptions.printOptions(options);
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> login();
                case "2" -> register();
                default -> System.out.println("--END ACCOUNT--");
            }
        }
    }
    public static void main(String[] args) {
        Account account = new Account();
        account.start();
        Menu menu_instance = new Menu();
        menu_instance.start();
    }
}
