import java.util.*;


class MapFunctions {

    public static void printWithSameLetter(Map<String, String> map) {
        map.entrySet()
                .stream()
                .filter(entry -> entry.getKey().charAt(0) == entry.getValue().charAt(0))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(" ");
            map.put(pair[0], pair[1]);
        }

        MapFunctions.printWithSameLetter(map);
    }
}