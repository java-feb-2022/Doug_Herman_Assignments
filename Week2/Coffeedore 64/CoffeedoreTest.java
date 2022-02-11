public class CoffeedoreTest {
    public static void main(String[] args) {
        OrderKiosk kiosk = new OrderKiosk();

        kiosk.addMenuItem("banana", 2.0);
        kiosk.addMenuItem("coffee", 1.5);
        kiosk.addMenuItem("latte", 4.5);
        kiosk.addMenuItem("capuccino", 3.0);
        kiosk.addMenuItem("muffin", 4.0);
        kiosk.addMenuItemByInput();

        kiosk.newOrder();
    }
    
}
