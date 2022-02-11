import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready = false;
    private ArrayList<Item> items;

    public Order(){
        this("Guest");
    }

    public Order(String name){
        this.name = name;
        items = new ArrayList<Item>();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getStatusMessage(){
        if (ready)
            return "Your order is ready.";
        else
            return "Thank you for waiting. Your order will be ready soon.";
    }

    public void setOrderReady(){
        this.ready = true;
    }

    public void setOrderNotReady(){
        this.ready = false;
    }

    public void addItem(Item item1){
        items.add(item1);
    }

    public double getTotal(){
        double total = 0.0;
        for (Item item : items)
            total += item.getPrice();
        return total;
    }

    public void display(){
        System.out.printf("\nCustomer Name: %s", name);
        for(Item item : items)
            System.out.printf("\n%s - $%s", item.getName(), item.getPrice());
        System.out.printf("\nTotal: $%s\n", this.getTotal());
    }
}