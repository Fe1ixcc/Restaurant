import java.util.Scanner;

public class MenuItem {

    public String name;
    public String description;
    public int price;

    public static MenuItem[] menu = {
            new MenuItem("Vegetable salad", "Abundant vegetables and salad dressing.", 12),
            new MenuItem("Super Chicken", "Grilled chicken breast topped with aromatic spices and vegetable.", 15),
            new MenuItem("BBQ Bacon Hamburger", "A juicy beef pie in black pepper sauce and topped with crispy bacon bits.", 13)
    };

    public MenuItem(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static void addMenuItem(MenuItem newItem) {
        MenuItem[] newMenu = new MenuItem[menu.length + 1];
        for (int i = 0; i < menu.length; i++) {
            newMenu[i] = menu[i];
        }
        newMenu[menu.length] = newItem;
        menu = newMenu;
    }
    public static void deleteMenuItem(MenuItem newItem){
        Scanner scanner = new Scanner(System.in);
        MenuItem[] newMenu = new MenuItem[menu.length - 1];
        int menuNumber = scanner.nextInt();
        for (int i = 0; i < menuNumber; i++) {
            newMenu[i] = menu[i];
        }
        for (int i = menuNumber; i < menu.length - 1; i++) {
            newMenu[i] = menu[i + 1];
        }
        newMenu[menu.length - 1] = newItem;
        menu = newMenu;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
