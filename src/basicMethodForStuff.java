public class basicMethodForStuff {
    public void stuffMethod(){
        System.out.println("""
                What do you want to do next?
                1)List menu;
                2)Add dishes:
                3)
                4)
                0)exit
                """);
    }
    public void menuPrint() {
        System.out.println("Welcome to order food");
        for (int i = 0; i < MenuItem.menu.length; i++) {
            System.out.println((i + 1) + ". " + MenuItem.menu[i].getName());
            System.out.println(MenuItem.menu[i].getDescription());
            System.out.println(MenuItem.menu[i].getPrice());
        }
    }
}
