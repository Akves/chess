public class PrintOptions {
    public static void printOptions( String[] options){
        int i = 1;
        for( String option : options ){
            System.out.println(i + ". " + option);
            i++;
        }
        System.out.println(i + ". " + "Exit");
        System.out.println("Choose: ");
    }
}
