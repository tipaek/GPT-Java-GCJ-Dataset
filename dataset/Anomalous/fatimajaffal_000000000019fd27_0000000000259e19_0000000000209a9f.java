import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            StringBuilder caseResult = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            String input = scanner.next();

            for (char c : input.toCharArray()) {
                int digit = Character.getNumericValue(c);

                while (stack.size() < digit) {
                    stack.push('(');
                    caseResult.append('(');
                }

                while (stack.size() > digit) {
                    stack.pop();
                    caseResult.append(')');
                }

                caseResult.append(c);
            }

            while (!stack.isEmpty()) {
                stack.pop();
                caseResult.append(')');
            }

            resultBuilder.append("Case #").append(i).append(": ").append(caseResult).append("\n");
        }

        System.out.print(resultBuilder.toString());
        scanner.close();
    }
}