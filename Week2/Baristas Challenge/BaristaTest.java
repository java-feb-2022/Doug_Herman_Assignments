public class BaristaTest {
    public static void main(String[] args) {
        
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");
        
        Item item1 = new Item("mocha", 3.25);
        Item item2 = new Item("latte", 2.75);
        Item item3 = new Item("drip coffee", 1.75);
        Item item4 = new Item("capuccino", 4.50);

        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item2);
        order2.addItem(item3);
        order3.addItem(item3);
        order3.addItem(item4);
        order4.addItem(item1);
        order4.addItem(item1);
        order5.addItem(item2);
        order5.addItem(item2);

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        order2.setOrderReady();
        order4.setOrderReady();

        System.out.println(order2.getStatusMessage());
        System.out.println(order4.getStatusMessage());
    }
}
