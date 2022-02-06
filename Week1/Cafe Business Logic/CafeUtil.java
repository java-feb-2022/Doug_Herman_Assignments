import java.util.ArrayList;

public class CafeUtil {

    // Calculate the total streak from the provided numWeeks
    public int getStreakGoal(int numWeeks) {
        int total = 0;

        for (int x = 1; x <= numWeeks; x++)
            total += x;

        return total;
    }

    // Return the total of the provided prices array
    public double getOrderTotal(double[] prices) {
        double total = 0.0;

        for(double price : prices)
            total += price;

        return total;
    }

    // Display the index of and entry for each item from menuItems
    public void displayMenu(ArrayList<String> menuItems) {
        for (int x = 0; x < menuItems.size(); x++)
            System.out.println(String.format("%d %s", x, menuItems.get(x)));
    }

    // Add a customer name to the array and display their position and the array
    public void addCustomer(ArrayList<String> customers) {
        System.out.print("Please enter your name:");
        String userName = System.console().readLine();

        System.out.println("Hello, " + userName);
        System.out.println(String.format("There are %d people in front of you.", customers.size()));

        customers.add(userName);

        System.out.println(customers);
    }

    // Print prices for a prooduct with multiple item discounts applied
    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);

        for (int x = 1; x <= maxQuantity; x++) {
            double discountedPrice = (price * x) - ((x - 1) * 0.50);
            System.out.println(String.format("%d - $%.2f", x, discountedPrice));
        }
    }

    // Display the menu with prices
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if(menuItems.size() != prices.size())
            return false;
        else {
            for(int x = 0; x < menuItems.size(); x++)
                System.out.println(String.format("%d %s -- $%.2f", x, menuItems.get(x), prices.get(x)));
            return true;
        }
    }

    public void addCustomers(ArrayList<String> customers) {
        System.out.print("Please enter your name:");
        String customerName = System.console().readLine();

        while (!customerName.equals("q")) {
            customers.add(customerName);
            System.out.println(customers);
            System.out.print("\nPlease enter your name:");
            customerName = System.console().readLine();
        }
    }
}