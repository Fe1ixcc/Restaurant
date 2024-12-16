public class MenuPrice {

    public int price ;

    public static MenuPrice[] menu = {
            new MenuPrice(12),
            new MenuPrice(15),
            new MenuPrice(13)
    };
    public MenuPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

