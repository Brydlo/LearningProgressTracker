import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static void transferAllElements(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        LinkedList<String> copyList = new LinkedList<>(linkedList);
        linkedList.clear();
        linkedList.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(copyList);
    }
}