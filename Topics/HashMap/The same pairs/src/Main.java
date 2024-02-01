import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        long pairs = map1.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(map2.get(e.getKey())))
                .count();
        System.out.println(pairs);

    }
}