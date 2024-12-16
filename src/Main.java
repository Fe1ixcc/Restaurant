import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        basicMethodForStuff stuff = new basicMethodForStuff();
        basicMethod consumer = new basicMethod();

        System.out.println("""
           Welcome to the restaurant system!
           Who are you(1/2)?
           1)Stuff
           2)consumer
           """);

        int choice = scanner.nextInt();
        priceScreening priceScreening =new priceScreening();


        if(choice == 1){
            stuff.stuffMethod();
        }
        else if(choice == 2){
            priceScreening.Print();
            consumer.interactiveSystem();
        }
        else {
            System.out.println("Wrong apply.");
        }
    }
}