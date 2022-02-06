import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Song A", "Lyrics A");
        map.put("Song B", "Lyrics B");
        map.put("Song C", "Lyrics C");
        map.put("Song D", "Lyrics D");

        System.out.println(map.get("Song C"));

        for(String key : map.keySet())
            System.out.println(String.format("%s : %s", key, map.get(key)));
    }
}
