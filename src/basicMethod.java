import java.util.Scanner;

public class basicMethod {
   /*
    * Prints the menu options.
    * This method displays a welcome message, then iterates through a predefined array of menu items,
    * printing the details of each menu item. Finally, it prompts the user to enter the order item number.
    */
    public static void menuPrint() {
    // Print the welcome message
    System.out.println("Welcome to order food");

    // Iterate through the menu items array and print each menu item's information
    for (int i = 0; i < MenuItem.menu.length; i++) {
        // Print the menu item's number and name
        System.out.println((i + 1) + ". " + MenuItem.menu[i].getName());
        // Print the menu item's description
        System.out.println(MenuItem.menu[i].getDescription());
        // Print the menu item's price
        System.out.println(MenuItem.menu[i].getPrice() + "$");
    }

    // Prompt the user to enter the order item number
    System.out.println("Please enter the order item number:");
}


    /*
     * Prints menu recommendations based on the user's budget.
     * This method prompts the user for their budget and recommends menu items based on predefined prices.
     * It uses console input to read the user's budget and provides different recommendations depending on the budget range.
     */
    public static void Print() {
    // Prompt the user to enter their budget
    System.out.println("What is your budget ?");
    // Create a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);
    // Read the user's budget
    float Budget = scanner.nextInt();

    // Provide recommendations based on the user's budget
    if (Budget < MenuItem.menu[0].price) {
        // If the budget is less than the price of the cheapest item, inform the user that their budget is too low
        System.out.println("Sorry, your budget is too low. ");
    }
    if (Budget < MenuItem.menu[2].price && Budget >= MenuItem.menu[0].price) {
        // If the budget is enough to buy the cheapest item but not the more expensive ones, recommend Vegetable salad
        System.out.println("We recommend Vegetable salad to you.");
    }
    if (Budget < MenuItem.menu[1].price && Budget >= MenuItem.menu[2].price) {
        // If the budget is enough to buy the two cheaper items but not the most expensive one, recommend Vegetable salad and Super Chicken
        System.out.println("We recommend Vegetable salad and Super Chicken to you.");
    }
    if (Budget >= MenuItem.menu[1].price) {
        // If the budget is enough to buy all items, recommend all menu items
        System.out.println("We recommend Vegetable salad, Super Chicken and BBQ Bacon Hamburger to you.");
    }
  }


    /*
     * This method implements an interactive ordering system.
     * It displays the menu, handles user orders, calculates the total price, and processes the payment method.
     */
    public static void interactiveSystem() {

    // Initialize total price to 0
    float totalPrice = 0;
    // Create a Scanner object for input
    Scanner scanner = new Scanner(System.in);
    // Initialize the variable to store the user's choice to continue ordering
    String answer = "";

    // Start the do-while loop to allow users to continue ordering until they choose to stop
    do {
        // Call the method to display the menu
        menuPrint();
        // Get the user's menu selection
        float menuId = scanner.nextFloat();
        // Validate the user's input, prompt for re-entry if the input is invalid (greater than 3)
        while (menuId > 3) {
            System.out.println("Please input the correct number");
            menuId = scanner.nextFloat();
        }

        // If the user's input is valid, process the order
        if (menuId <= 3) {
            // Display the user's choice and the price of the item
            System.out.println("Your choice is " + MenuItem.menu[(int) menuId - 1].getName());
            System.out.println("The price of " + MenuItem.menu[(int) menuId - 1].getName() + " is " + MenuItem.menu[(int) menuId - 1].getPrice() + "$");
            // Prompt the user to enter the quantity of the item
            System.out.println("Please enter the number of " + MenuItem.menu[(int) menuId - 1].getName());

            // Get the quantity of the item ordered by the user
            int num1;
            int number = scanner.nextInt();
            // Calculate the subtotal for this order
            num1 = number * MenuItem.menu[(int) menuId - 1].getPrice();

            // Check if the user is eligible for a discount
            if (num1 >= 50) {
                System.out.println("You have already spent over 50, you will receive a 20% discount");
                // Apply the discount
                num1 = (int) (num1 * 0.8);
                System.out.println("The total price is " + num1);
            } else {
                System.out.println("The total price is " + num1);
            }
            // Add the subtotal to the total price
            totalPrice += num1;

            // Ask the user if they want to continue ordering
            System.out.println("Would you like to continue ordering(yes/no)?");
            answer = scanner.next();
        }
    } while (answer.equals("yes"));
    // Display the final total price
    System.out.println("The final total price is " + totalPrice);

    // Prompt the user to select a payment method
    System.out.println("""
            "Please select the payment method （1/2/3）:
            1. Alipay
            2. Credit card
            3. WeChat Pay
            """);
    // Get the user's selected payment method
    int paymentMethod = scanner.nextInt();
    // Process the payment method using a switch statement
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
    // Display a "thank you" message
    System.out.println("Thank you for using our service");
  }
}
