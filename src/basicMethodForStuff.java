import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class basicMethodForStuff {
    Scanner scanner = new Scanner(System.in);

    public void stuffMethod() {
        String option = "";
        int choice;
        do {
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
                case 1-> menuPrint();
                case 2-> addDish();
                case 3-> deleteDish();
                case 4-> {
                    try {
                        printMenu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> System.out.println("Invalid option entered"+choice);
            }
            System.out.println("Continue operating(yes/no)?");
            option = scanner.next();
        } while (option.equals("yes"));
    }

    public void addDish() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to add?");
        String name = scanner.nextLine();
        System.out.println("What is the description?");
        String description = scanner.nextLine();
        System.out.println("What is the price?");
        int price = scanner.nextInt();
        MenuItem newFood = new MenuItem(name, description, price);
        MenuItem.addMenuItem(newFood);
        System.out.println("Added successfully");
    }

    public void deleteDish() {
        System.out.println("Which one do you want to delete?");
        MenuItem newMenu = null;
        MenuItem.deleteMenuItem(newMenu);
        System.out.println("Deleted successfully");
    }

    public void menuPrint() {
        System.out.println("Welcome to order food");
        for (int i = 0; i < MenuItem.menu.length; i++) {
            System.out.println((i + 1) + ". " + MenuItem.menu[i].getName());
            System.out.println(MenuItem.menu[i].getDescription());
            System.out.println(MenuItem.menu[i].getPrice());
        }
    }

    public void printMenu() throws IOException {
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir + File.separator + "arrayOutput.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for (MenuItem element : MenuItem.menu) {
            writer.write(element.getName());
            writer.write(element.getDescription());
            writer.write(element.getPrice());
            writer.newLine();
        }
        writer.close();
        System.out.println("Array has been written to " + file.getAbsolutePath());

    }
}
