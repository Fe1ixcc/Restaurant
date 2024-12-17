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
                2)Add dishes:
                3)
                4)
                0)exit
                """);
            choice = scanner.nextInt();
            if(choice == 1){
                menuPrint();
            }
            if(choice == 2){
                addDish ();
            }
            System.out.println("Continue operating(yes/no)?");
            option = scanner.next();
        }while (option.equals("yes"));
    }
    public void addDish () {
        System.out.println("What do you want to add?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("What is the description?");
        String description = scanner.nextLine();
        System.out.println("What is the price?");
        int price = scanner.nextInt();
        MenuItem newFood = new MenuItem(name, description, price);
        MenuItem.addMenuItem(newFood);
        System.out.println("Added successfully");
    }
    public void menuPrint () {
        System.out.println("Welcome to order food");
        for (int i = 0; i < MenuItem.menu.length; i++) {
            System.out.println((i + 1) + ". " + MenuItem.menu[i].getName());
            System.out.println(MenuItem.menu[i].getDescription());
            System.out.println(MenuItem.menu[i].getPrice());
        }
    }

}
