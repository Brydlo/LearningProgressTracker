import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> deque = new ArrayDeque<>();

        int numberOfElements = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfElements; i++) {
            deque.push(scanner.nextLine());
        }

        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
    }
}