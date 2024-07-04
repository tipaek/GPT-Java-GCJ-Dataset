import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        StringBuilder finalResult = new StringBuilder();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            Stack<String> parenthesesStack = new Stack<>();
            StringBuilder caseResult = new StringBuilder();
            String[] inputTokens = scanner.nextLine().split("");
            int[] numbers = new int[inputTokens.length];

            for (int i = 0; i < inputTokens.length; i++) {
                numbers[i] = Integer.parseInt(inputTokens[i]);
            }

            caseResult.append(generateParentheses("(", numbers[0], parenthesesStack)).append(numbers[0]);

            for (int i = 1; i < numbers.length; i++) {
                int difference = numbers[i] - numbers[i - 1];
                if (difference == 0) {
                    caseResult.append(numbers[i]);
                } else if (difference > 0) {
                    caseResult.append(generateParentheses("(", difference, parenthesesStack)).append(numbers[i]);
                } else {
                    for (int j = 0; j < Math.abs(difference); j++) {
                        parenthesesStack.pop();
                    }
                    caseResult.append(generateParentheses(")", Math.abs(difference), parenthesesStack)).append(numbers[i]);
                }
            }

            while (!parenthesesStack.isEmpty()) {
                caseResult.append(parenthesesStack.pop());
            }

            finalResult.append("Case #").append(caseIndex + 1).append(": ").append(caseResult.toString()).append("\n");
        }

        System.out.println(finalResult.toString());
        scanner.close();
    }

    static String generateParentheses(String parenthesis, int count, Stack<String> stack) {
        StringBuilder parenthesesBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            parenthesesBuilder.append(parenthesis);
            if (parenthesis.equals("(")) {
                stack.push(")");
            }
        }
        return parenthesesBuilder.toString();
    }
}