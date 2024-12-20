import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class basicMethodForStaff {
    Scanner scanner = new Scanner(System.in);

    /*
     * Displays the interactive menu for the user to choose the next operation
     * This method provides options for the user to list the menu, add, delete dishes, print the menu, or exit
     * It uses a do-while loop to allow the user to repeatedly operate until they choose to exit
     */
    public void staffMethod() {
        String option = "";
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
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> menuPrint();
                case 2 -> addDish();
                case 3 -> deleteDish();
                case 4 -> {
                    try {
                        printMenu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> System.out.println("Invalid option entered" + choice); // Handle invalid input
            }
            System.out.println("Continue operating(yes/no)?");
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to add?");
        String name = scanner.nextLine();
        System.out.println("What is the description?");
        String description = scanner.nextLine();
        System.out.println("What is the price?");
        int price = scanner.nextInt();
        MenuItem newFood = new MenuItem(name, description, price);// Create a new MenuItem object using the provided details

        // Add the new dish to the menu
        MenuItem.addMenuItem(newFood);
        System.out.println("Added successfully");
    }

    /*
     * Deletes a dish from the menu.
     * This method reads the dish number to be deleted from the user input and performs the deletion operation.
     */
    public void deleteDish() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to delete?");
        int number = scanner.nextInt();
        if (number > 0 && number <= MenuItem.menu.length) {
            // Call the deleteMenuItem method to delete the corresponding dish
            MenuItem.deleteMenuItem(MenuItem.menu[number - 1]);
            // Notify the user that the dish has been successfully deleted
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Invalid item number");
        }
    }

    /*
     * Prints the menu options.
     * This method iterates through the menu items array and outputs the details of each menu item,
     * including its number, name, description, and price.
     */
    public void menuPrint() {
        System.out.println("Welcome to order food");
     for (int i = 0; i < MenuItem.menu.length; i++) {
        System.out.println((i + 1) + ". " + MenuItem.menu[i].getName());
        System.out.println(MenuItem.menu[i].getDescription());
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
        // Create a writer object to write to the file
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
    System.out.println("Array has been written to " + file.getAbsolutePath());
}

}
