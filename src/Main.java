import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuItem[] MenuItem;
        MenuItem = new MenuItem[3];
        MenuItem[0] = new MenuItem("Vegetable salad", "Abundant vegetables and salad dressing.", 12);
        MenuItem[1] = new MenuItem("Super Chicken", "Grilled chicken breast topped with aromatic spices and vegetable.", 15);
        MenuItem[2] = new MenuItem("BBQ Bacon Hamburger", "A juicy beef pie in black pepper sauce and topped with crispy bacon bits.", 13);
        System.out.println("Welcome to order food");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1 + ". " + MenuItem[i].getName());
            System.out.println(MenuItem[i].getDescription());
            System.out.println("price : " + MenuItem[i].getPrice());
        }
        System.out.println("Please enter the order item number:");
        Scanner scanner = new Scanner(System.in);
        float menuId = scanner.nextFloat();
        if (menuId > 3) {
            int a = 1;
            while (a < 2) {
                System.out.println("Please input the correct number");
                menuId = scanner.nextFloat();
                if (menuId <= 3) {
                    a++;
                    System.out.println("Your choice is " + MenuItem[(int) menuId - 1].getName());
                    if (menuId == 1) {
                        System.out.println("The price of Vegetable salad is 12");
                        System.out.println("Please enter the number of Vegetable salad:");
                        int num1 = scanner.nextInt();
                        System.out.println("The total price is " + num1 * 12);
                    } else if (menuId == 2) {
                        System.out.println("The price of Super Chicken is 15");
                        System.out.println("Please enter the number of Super Chicken:");
                        int num2 = scanner.nextInt();
                        System.out.println("The total price is " + num2 * 15);
                    } else if (menuId == 3) {
                        System.out.println("The price of BBQ Bacon Hamburger is 13");
                        System.out.println("Please enter the number of BBQ Bacon Hamburger:");
                        int num3 = scanner.nextInt();
                        System.out.println("The total price is " + num3 * 13);
                    }
                }
            }
        }
    }
}


