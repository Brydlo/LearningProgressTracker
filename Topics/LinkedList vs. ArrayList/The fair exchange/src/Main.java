import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static void changeHeadsAndTails(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        String firstFromLinked = linkedList.getFirst();
        String lastFromLinked = linkedList.getLast();
        String lastFromArray = arrayList.get(arrayList.size() - 1);
        String firstFromArray = arrayList.get(0);

        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.addFirst(firstFromArray);
        linkedList.addLast(lastFromArray);
        arrayList.remove(0);
        arrayList.remove(arrayList.size() - 1);
        arrayList.add(0, firstFromLinked);
        arrayList.add(lastFromLinked);
    }
}