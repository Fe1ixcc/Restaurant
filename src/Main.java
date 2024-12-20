import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    basicMethodForStaff stuff = new basicMethodForStaff();

    System.out.println("""
            \u001b[34;4;255m
       Welcome to the restaurant system!
       Who are you(1/2)?
       1)Staff
       2)Consumer
       """);

    int choice = scanner.nextInt();

    switch (choice) {
        case 1 -> stuff.staffMethod(); // Call staff method if user is staff
        case 2 -> {
            basicMethod.Print(); // Print something (method name suggests printing)
            basicMethod.interactiveSystem(); // Start interactive system for consumer
        }
        default -> System.out.println("Invalid option entered: " + choice); // Handle invalid choices
    }
  }
}