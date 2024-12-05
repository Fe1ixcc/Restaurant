import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        basicMethodForStuff stuff = new basicMethodForStuff();
        basicMethod consumer = new basicMethod();

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
           Welcome to the restaurant system!
           Who are you(1/2)?
           1)Stuff
           2)consumer
           """);

        int choice = scanner.nextInt();

        if(choice == 1){
            stuff.stuffMethod();
        }
        if(choice == 2){
            consumer.interactiveSystem();
        }
        else {
            System.out.println("Wrong apply.");
        }
    }
}