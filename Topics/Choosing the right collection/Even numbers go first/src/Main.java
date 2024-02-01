import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Deque<Integer> dek = new ArrayDeque<>();
        int times = s.nextInt();
        for (int i = 0; i < times; i++) {
            int num = s.nextInt();
            if(num % 2 == 0) dek.push(num);
            else dek.add(num);
        }
        dek.forEach(System.out::println);
    }
}