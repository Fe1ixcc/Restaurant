import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class basicMethodForStuff {
    Scanner scanner = new Scanner(System.in);

    /*
     * Displays the interactive menu for the user to choose the next operation
     * This method provides options for the user to list the menu, add, delete dishes, print the menu, or exit
     * It uses a do-while loop to allow the user to repeatedly operate until they choose to exit
     */
    public void stuffMethod() {
        // Initialize the option variable to control the loop
        String option = "";
        // Declare the choice variable to store the user's selection
        int choice;
        // Use a do-while loop to continuously display the menu until the user chooses to exit
        do {
            // Display the menu options
            System.out.println("""
                    What do you want to do next?
                    1)List menu;
                    2)Add dishes;
                    3)Delete dishes;
                    4)Print the menu;
                    0)exit.
                    """);
            // Read the user's selection
            choice = scanner.nextInt();
            // Use a switch statement to handle different choices
            switch (choice){
                case 1 -> menuPrint(); // List the menu
                case 2 -> addDish(); // Add dishes
                case 3 -> deleteDish(); // Delete dishes
                case 4 -> {
                    // Print the menu, may throw an IOException
                    try {
                        printMenu();
                    } catch (IOException e) {
                        // Wrap and throw an exception if an IOException occurs
                        throw new RuntimeException(e);
                    }
                }
                default -> System.out.println("Invalid option entered" + choice); // Handle invalid input
            }
            // Ask the user if they want to continue operating
            System.out.println("Continue operating(yes/no)?");
            // Read the user's response
            option = scanner.next();
        } while (option.equals("yes")); // If the user chooses to continue, loop again
    }

    /*
     * Adds a dish to the menu.
     * This method prompts the user to input details about a new dish, including its name,
     * description, and price. It then creates a new MenuItem object with this information
     * and adds it to the menu. Finally, it prints a success message indicating that the dish
     * has been added.
     */
public void addDish() {
    // Create a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Prompt the user for the dish name
    System.out.println("What do you want to add?");
    String name = scanner.nextLine();

    // Prompt the user for the dish description
    System.out.println("What is the description?");
    String description = scanner.nextLine();

    // Prompt the user for the dish price
    System.out.println("What is the price?");
    int price = scanner.nextInt();

    // Create a new MenuItem object using the provided details
    MenuItem newFood = new MenuItem(name, description, price);

    // Add the new dish to the menu
    MenuItem.addMenuItem(newFood);

    // Print a success message
    System.out.println("Added successfully");
}

    /*
     * Deletes a dish from the menu.
     * This method reads the dish number to be deleted from the user input and performs the deletion operation.
     */
    public void deleteDish() {
        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter the number of the dish to be deleted
        System.out.println("What do you want to delete?");
        // Read the dish number entered by the user
        int number = scanner.nextInt();
        // Check if the entered dish number is within the valid range
        if (number > 0 && number <= MenuItem.menu.length) {
            // Call the deleteMenuItem method to delete the corresponding dish
            MenuItem.deleteMenuItem(MenuItem.menu[number - 1]);
            // Notify the user that the dish has been successfully deleted
            System.out.println("Deleted successfully");
        } else {
            // If the entered dish number is not within the valid range, notify the user of the invalid input
            System.out.println("Invalid item number");
        }
    }

    /*
     * Prints the menu options.
     * This method iterates through the menu items array and outputs the details of each menu item,
     * including its number, name, description, and price.
     */
public void menuPrint() {
    // Print the welcome message for ordering food
    System.out.println("Welcome to order food");
    // Loop through the menu items array to display all available dishes
    for (int i = 0; i < MenuItem.menu.length; i++) {
        // Print the current menu item's number and name
        System.out.println((i + 1) + ". " + MenuItem.menu[i].getName());
        // Print the current menu item's description
        System.out.println(MenuItem.menu[i].getDescription());
        // Print the current menu item's price
        System.out.println(MenuItem.menu[i].getPrice());
    }
}

    /*
     * Prints the menu by writing the details of each menu item into a text file
     * This method covers the process of file path acquisition, file writing, and outputting the file location
     * @throws IOException If an I/O error occurs while writing to the file
     */
public void printMenu() throws IOException {
    // Get the current working directory
    String currentDir = System.getProperty("user.dir");
    // Create a File object with the specified file path
    File file = new File(currentDir + File.separator + "arrayOutput.txt");
    // Create a BufferedWriter object to write to the file
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));

    // Iterate over the menu items and write their details to the file
    for (MenuItem element : MenuItem.menu) {
        // Write the name of the menu item
        writer.write(element.getName());
        // Write the description of the menu item
        writer.write(element.getDescription());
        // Write the price of the menu item
        writer.write(element.getPrice());
        // Write a new line after each menu item
        writer.newLine();
    }
    // Close the BufferedWriter
    writer.close();
    // Print the absolute path of the file where the menu has been written
    System.out.println("Array has been written to " + file.getAbsolutePath());
}

}
