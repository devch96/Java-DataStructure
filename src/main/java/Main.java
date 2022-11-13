import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Grace");

        System.out.println(list);

        list.remove("Grace");
        System.out.println(list);
        System.out.println(list.get(0));
    }
}