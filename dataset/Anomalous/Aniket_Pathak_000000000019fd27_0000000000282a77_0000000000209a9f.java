import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            String input = scanner.next();
            int length = input.length();

            Stack<Character> stack = new Stack<>();
            int openBrackets = 0;

            for (int i = 0; i < length; i++) {
                char currentChar = input.charAt(i);
                int digit = Character.getNumericValue(currentChar);

                while (openBrackets < digit) {
                    stack.push('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    stack.push(')');
                    openBrackets--;
                }
                stack.push(currentChar);
            }

            while (openBrackets > 0) {
                stack.push(')');
                openBrackets--;
            }

            StringBuilder output = new StringBuilder();
            for (char ch : stack) {
                output.append(ch);
            }

            System.out.println("Case #" + t + ": " + output);
        }
    }
}