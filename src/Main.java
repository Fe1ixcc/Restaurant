import java.util.Scanner;

public class Main {
    //Main entry point of the program.
    public static void main(String[] args) {
    // Create a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);
    // Instantiate an object of basicMethodForStuff class
    basicMethodForStuff stuff = new basicMethodForStuff();

    // Display welcome message and prompt for user role selection
    System.out.println("""
       Welcome to the restaurant system!
       Who are you(1/2)?
       1)Staff
       2)Consumer
       """);

    // Read user's choice
    int choice = scanner.nextInt();

    // Process user's choice
    switch (choice) {
        case 1 -> stuff.stuffMethod(); // Call staff method if user is staff
        case 2 -> {
            basicMethod.Print(); // Print something (method name suggests printing)
            basicMethod.interactiveSystem(); // Start interactive system for consumer
        }
        default -> System.out.println("Invalid option entered: " + choice); // Handle invalid choices
    }
}

}