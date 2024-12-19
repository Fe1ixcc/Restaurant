import java.util.Scanner;

public class MenuItem {

    public String name;
    public String description;
    public double price;

    public static Scanner scanner = new Scanner(System.in);

    public static MenuItem[] menu = {
            new MenuItem("Vegetable salad", "Abundant vegetables and salad dressing.", 12),
            new MenuItem("Super Chicken", "Grilled chicken breast topped with aromatic spices and vegetable.", 15),
            new MenuItem("BBQ Bacon Hamburger", "A juicy beef pie in black pepper sauce and topped with crispy bacon bits.", 13)
    };

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /*
    Deletes a menu item from the menu array.
    This method creates a new array with one less element and copies all items except the one to be deleted.
    @param newItem The MenuItem object to be deleted from the menu.
    */
public static void deleteMenuItem(MenuItem newItem) {
    MenuItem[] newMenu = new MenuItem[menu.length - 1];
    int newIndex = 0;

    // Iterate through the current menu array
    for (int i = 0; i < menu.length; i++) {
        // Copy the current item to the new array if it is not the item to be deleted
        if (menu[i] != null && !menu[i].getName().equals(newItem.getName())) {
            newMenu[newIndex++] = menu[i];
        }
    }

    // Update the menu array with the new array
    menu = newMenu;
    System.out.println("The menu has been updated.");
}

    /*
    Adds a new menu item to the existing menu.
    This method creates a new array of MenuItems with a length one greater than the current menu array,
    copies all existing items into this new array, adds the new item at the end, and then reassigns the
    original menu reference to point to this new array. It also prints a message indicating that the menu
    has been updated.
    @param newItem The new MenuItem object to be added to the menu.
    */
public static void addMenuItem(MenuItem newItem) {
    MenuItem[] newMenu = new MenuItem[menu.length + 1]; // Create a new array with increased size
    for (int i = 0; i < menu.length; i++) {
        newMenu[i] = menu[i]; // Copy existing menu items to the new array
    }
    newMenu[menu.length] = newItem; // Add the new menu item at the end of the new array
    for (int i = 0; i < newMenu.length; i++) {
        newMenu[i] = new MenuItem(newMenu[i].getName(), newMenu[i].getDescription(), newMenu[i].getPrice()); // Reinitialize each MenuItem in the new array
    }
    System.out.println("The menu has been updated."); // Print update confirmation
    menu = newMenu; // Update the reference to the new menu array
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
        return (int) price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

