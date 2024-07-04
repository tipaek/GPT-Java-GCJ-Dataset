import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        parenthesisDepthProblem();
    }
    
    private static void parenthesisDepthProblem() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int eachTestCase = 1; eachTestCase <= t; eachTestCase++) {
            String input = scan.next();
            String formattedResult = String.format("Case #%d: %s", eachTestCase, processUsingStack(input));
            System.out.println(formattedResult);
        }
        scan.close();
    }

    private static String processUsingStack(String input) {
        int braceCount = 0;
        Stack<Character> stack = new Stack<>();

        char initial = input.charAt(0);
        int ini = Integer.parseInt(initial + "");
        for (int i = 0; i < ini; i++) {
            stack.push('(');
            braceCount++;
        }
        stack.push(initial);

        input = input.substring(1);
        for (char c : input.toCharArray()) {
            int count = Integer.parseInt(c + "");
            char topChar = stack.peek();
            if (topChar != '(' && topChar != ')') {
                if (topChar > c) {
                    for (int i = braceCount; i > count; i--) {
                        stack.push(')');
                        braceCount--;
                    }
                    stack.push(c);
                } else if (topChar < c) {
                    for (int i = braceCount; i < count; i++) {
                        stack.push('(');
                        braceCount++;
                    }
                    stack.push(c);
                } else {
                    stack.push(c);
                }
            } else {
                if (braceCount < count) {
                    for (int i = braceCount; i < count; i++) {
                        stack.push('(');
                        braceCount++;
                    }
                    stack.push(c);
                } else if (braceCount > count) {
                    for (int i = braceCount; i > count; i--) {
                        stack.push(')');
                        braceCount--;
                    }
                    stack.push(c);
                } else {
                    stack.push(c);
                }
            }
        }
        for (int i = 0; i < braceCount; i++) {
            stack.push(')');
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

}
