import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        basicMethodForStuff stuff = new basicMethodForStuff();

        System.out.println("""
           Welcome to the restaurant system!
           Who are you(1/2)?
           1)Stuff
           2)consumer
           """);

        int choice = scanner.nextInt();
        priceScreening priceScreening =new priceScreening();

        switch (choice){
            case 1-> stuff.stuffMethod();
            case 2 -> {
                priceScreening.Print();
                basicMethod.interactiveSystem();
            }
            default -> System.out.println("Invalid option entered"+choice);
        }
    }
}