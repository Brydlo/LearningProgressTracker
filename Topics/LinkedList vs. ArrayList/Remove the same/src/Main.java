import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ListOperations {
    public static void removeTheSame(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i).equals(linkedList.get(i))) {
                arrayList.remove(i);
                linkedList.remove(i);
            }
        }
    }
}