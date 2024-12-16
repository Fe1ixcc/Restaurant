import java.util.Scanner;
public class priceScreening {
    public void Print() {
        System.out.println("What is your budget ?");
        Scanner scanner = new Scanner(System.in);
        float Budget = scanner.nextInt();
        if (Budget<MenuPrice.menu[0].price){
            System.out.println("Sorry, your budget is too low. ");
        }
        if (Budget<MenuPrice.menu[2].price && Budget>=MenuPrice.menu[0].price){
            System.out.println("We recommend Vegetable salad to you.");
        }
        if (Budget<MenuPrice.menu[1].price && Budget>=MenuPrice.menu[2].price) {
            System.out.println("We recommend Vegetable salad and Super Chicken to you.");
        }
        if (Budget>=MenuPrice.menu[1].price){
            System.out.println("We recommend Vegetable salad , Super Chicken and BBQ Bacon Hamburger to you.");
        }
    }
}
