import java.io.Console;
import java.util.ArrayList;

public class OrderKiosk {

    ArrayList<Item> menu;
    ArrayList<Order> orders;

    public OrderKiosk(){
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
        int index = menu.size();
        menu.add(new Item(index, name, price));
    }

    public void addMenuItemByInput(){
        System.out.print("Please enter the item name: ");
        String name = System.console().readLine();
        System.out.print("Please enter the price: $");
        double price = Double.parseDouble(System.console().readLine());

        addMenuItem(name, price);
    }

    public void displayMenu(){
        for(Item item : menu){
            System.out.printf("\n%d %s -- $%.2f", item.getIndex(), item.getName(), item.getPrice());
        }
    }

    public void newOrder(){
        System.out.print("\nPlease enter customer name for new order: ");
        String name = System.console().readLine();
        orders.add(new Order(name));

        displayMenu();
        System.out.print("\nPlease enter a menu item index or q to quit: ");
        String itemNumber = System.console().readLine();

        while (!itemNumber.equals("q")){
            if(Integer.parseInt(itemNumber) < menu.size() && Integer.parseInt(itemNumber) >= 0)
                orders.get(orders.size()-1).addItem(menu.get(Integer.parseInt(itemNumber)));
            else
                System.out.println("Invalid selection.");

                displayMenu();
                System.out.print("\nPlease enter a menu item index or q to quit: ");
                itemNumber = System.console().readLine();
        }

        orders.get(orders.size()-1).display();
    }
}
