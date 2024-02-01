import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        int num, max = Integer.MIN_VALUE;

        Scanner s = new Scanner(System.in);
        int times = s.nextInt();
        s.nextLine();

        for (int i = 0; i < times; i++) {
            String input = s.nextLine();
            if (input.startsWith("push")) {
                num = Integer.parseInt(input.split(" ")[1]);
                max = maxStack.isEmpty() ? num : Math.max(num, maxStack.peek());
                stackInt.push(num);
                maxStack.push(max);
            } else if (input.equals("pop")) {
                stackInt.pop();
                maxStack.pop();
            } else if (input.equals("max")) {
                System.out.println(maxStack.peek());
            }
        }
    }
}