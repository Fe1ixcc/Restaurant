import java.util.Scanner;

public class basicMethod {

    public static void menuPrint() {
        System.out.println("Welcome to order food");
        for (int i = 0; i < MenuItem.menu.length; i++) {
            System.out.println((i + 1) + ". " + MenuItem.menu[i].getName());
            System.out.println(MenuItem.menu[i].getDescription());
            System.out.println(MenuItem.menu[i].getPrice() + "$");
        }
        System.out.println("Please enter the order item number:");
    }

    public static void interactiveSystem() {

        float totalPrice = 0;
        Scanner scanner = new Scanner(System.in);
        String answer = "";

        do {
            menuPrint();
            float menuId = scanner.nextFloat();
            while (menuId > 3) {
                System.out.println("Please input the correct number");
                menuId = scanner.nextFloat();
            }

            if (menuId <= 3) {
                System.out.println("Your choice is " + MenuItem.menu[(int) menuId - 1].getName());
                System.out.println("The price of " + MenuItem.menu[(int) menuId - 1].getName() + " is " + MenuItem.menu[(int) menuId - 1].getPrice() + "$");
                System.out.println("Please enter the number of " + MenuItem.menu[(int) menuId - 1].getName());

                int num1;
                int number = scanner.nextInt();

                num1 = number * MenuItem.menu[(int) menuId - 1].getPrice();

                if (num1 >= 50) {
                    System.out.println("You have already spent over 50, you will receive a 20% discount");
                    num1 = (int) (num1 * 0.8);
                    System.out.println("The total price is " + num1);
                } else {
                    System.out.println("The total price is " + num1);
                }
                totalPrice += num1;

                System.out.println("Would you like to continue ordering(yes/no)?");
                answer = scanner.next();
            }
        } while (answer.equals("yes"));
        System.out.println("The final total price is " + totalPrice);

        System.out.println("""
                "Please select the payment method （1/2/3）:
                1. Alipay
                2. Credit card
                3. WeChat Pay
                """);
        int paymentMethod = scanner.nextInt();
        switch (paymentMethod) {
            case 1:
                System.out.println("Alipay payment");
                break;
            case 2:
                System.out.println("Credit card payment");
                break;
            case 3:
                System.out.println("WeChat Pay payment");
                break;
            default:
                System.out.println("Invalid payment method");
                break;
        }
        System.out.println("Thank you for using our service");
    }
}
