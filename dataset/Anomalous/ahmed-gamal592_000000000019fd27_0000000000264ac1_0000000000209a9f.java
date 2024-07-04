import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static String generateParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '0') {
                while (!stack.isEmpty()) {
                    stack.pop();
                    result.append(')');
                }
                result.append(currentChar);
            } else {
                int num = Character.getNumericValue(currentChar);

                while (stack.size() < num) {
                    result.append('(');
                    stack.push('(');
                }
                while (stack.size() > num) {
                    stack.pop();
                    result.append(')');
                }

                result.append(currentChar);
            }
        }

        while (!stack.isEmpty()) {
            stack.pop();
            result.append(')');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        int caseNumber = 1;

        while (numberOfTests > 0) {
            numberOfTests--;

            String inputLine = scanner.nextLine();
            System.out.println("Case #" + caseNumber++ + ": " + generateParentheses(inputLine));
        }
    }
}