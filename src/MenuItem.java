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
