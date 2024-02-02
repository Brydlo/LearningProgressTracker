import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String expression = s.nextLine();
        boolean result = isBalanced(expression);
        System.out.println(result);
    }

    static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            char bracket = expression.charAt(i);
            switch (bracket) {
                case '{':
                case '(':
                case '[':
                    stack.push(bracket);
                    break;
                case '}':
                case ')':
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        char matchingBracket = stack.pop();
                        if (bracket == '}' && matchingBracket != '{' ||
                                bracket == ')' && matchingBracket != '(' ||
                                bracket == ']' && matchingBracket != '[') {
                            return false;
                        }
                    }
            }
        }
        return stack.isEmpty();
    }
}