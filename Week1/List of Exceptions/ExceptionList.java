import java.util.ArrayList;

public class ExceptionList {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int x = 0; x < myList.size(); x++) {
            try {
                Integer castedValue = (Integer) myList.get(x);
                System.out.println(String.format("%d: %d", x, castedValue));
            }
            catch (ClassCastException e) {
                System.out.println(String.format("%d: %s: %s", x, myList.get(x), e));
            }
        }
    }
}
