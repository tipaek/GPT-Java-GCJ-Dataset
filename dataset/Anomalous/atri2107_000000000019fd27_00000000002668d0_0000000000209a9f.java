import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 0; k < t; k++) {
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();
            char[] input = sc.next().toCharArray();
            
            stack.push(input[0]);
            for (int i = 1; i < input.length; i++) {
                if (input[i] == stack.peek()) {
                    stack.push(input[i]);
                } else {
                    int x = Character.getNumericValue(stack.peek());
                    appendBrackets(result, x, '(');
                    appendStackContent(result, stack);
                    appendBrackets(result, x, ')');
                    stack.push(input[i]);
                }
            }
            int x = Character.getNumericValue(stack.peek());
            appendBrackets(result, x, '(');
            appendStackContent(result, stack);
            appendBrackets(result, x, ')');
            
            System.out.println("Case #" + (k + 1) + ": " + result.toString());
        }
        sc.close();
    }

    private static void appendBrackets(StringBuilder result, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
    }

    private static void appendStackContent(StringBuilder result, Stack<Character> stack) {
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
    }
}