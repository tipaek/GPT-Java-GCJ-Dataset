import java.util.*;
import java.io.*;

public class Solution {

    public static void addBrackets(Stack<Character> stack, char digit, int depth) {
        int num = Character.getNumericValue(digit);
        for (int i = depth == 1 ? 1 : 0; i < num; i++) {
            stack.add('(');
        }
        stack.add(digit);
        for (int i = 0; i < num; i++) {
            stack.add(')');
        }
    }

    public static void insertDigit(Stack<Character> stack, char digit) {
        int num = Character.getNumericValue(digit);
        for (int i = 0; i < num; i++) {
            stack.pop();
        }
        stack.add(digit);
        for (int i = 0; i < num; i++) {
            stack.add(')');
        }
    }

    public static int checkLastDepth(Stack<Character> stack) {
        Stack<Character> tempStack = (Stack<Character>) stack.clone();
        if (tempStack.isEmpty()) {
            return 0;
        }

        char top = tempStack.peek();
        while (top == ')') {
            tempStack.pop();
            top = tempStack.peek();
        }

        return Character.getNumericValue(top);
    }

    public static void printStack(Stack<Character> stack) {
        if (stack.isEmpty()) {
            return;
        }

        char top = stack.peek();
        stack.pop();

        printStack(stack);
        System.out.print(top);
        stack.push(top);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String digits = scanner.next();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < digits.length(); j++) {
                char digit = digits.charAt(j);
                int depth = checkLastDepth(stack);
                if (depth < Character.getNumericValue(digit)) {
                    if (depth == 1) {
                        stack.pop();
                    }
                    addBrackets(stack, digit, depth);
                } else {
                    insertDigit(stack, digit);
                }
            }
            System.out.print("Case #" + i + ": ");
            printStack(stack);
            System.out.println();
        }
    }
}