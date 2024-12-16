import java.util.Scanner;
public class priceScreening {
    public void Print() {
        System.out.println(" What is your budget ?");
        Scanner scanner = new Scanner(System.in);
        float Budget = scanner.nextInt();
        if (Budget<12){
            System.out.println(" Sorry, your budget is too low. ");
        }
        if (Budget<13 && Budget>=12){
            System.out.println(" We recommend Vegetable salad to you.");
        }
        if (Budget<15 && Budget>=13) {
            System.out.println(" We recommend Vegetable salad and Super Chicken to you.");
        }
        if (Budget>=15){
            System.out.println(" We recommend Vegetable salad , Super Chicken and BBQ Bacon Hamburger to you.");
        }
    }
}
