import java.util.Scanner;

public class basicMethodForStuff {
    public void stuffMethod() {
        System.out.println("""
                What do you want to do next?
                1)List menu;
                2)Add dishes:
                3)
                4)
                0)exit
                """);
        Scanner scanner = new Scanner(System.in);
        int priceScreening = scanner.nextInt();

        switch (priceScreening) {
            case 1:
                menuPrint();
            case 2:
                addDish();
            case 3:
                break;
        }
    }
        public void addDish () {
        System.out.println("What do you want to add?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("What is the description?");
        String description = scanner.nextLine();
        System.out.println("What is the price?");
        int price = scanner.nextInt();
        MenuItem.menu[MenuItem.menu.length] = new MenuItem(name, description, price);
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
