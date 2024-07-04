import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numberOfTestCases; i++) {
            String testCase = scanner.nextLine();
            result.append("Case #").append(i + 1).append(": ").append(getMinNestedByParentheses(testCase)).append("\n");
        }
        System.out.print(result.toString());
    }

    public static String getMinNestedByParentheses(String input) {
        StringBuilder answer = new StringBuilder();
        int opened = 0;

        for (char ch : input.toCharArray()) {
            int num = Character.getNumericValue(ch);
            while (opened < num) {
                answer.append("(");
                opened++;
            }
            while (opened > num) {
                answer.append(")");
                opened--;
            }
            answer.append(num);
        }

        // Close any remaining opened parentheses
        while (opened > 0) {
            answer.append(")");
            opened--;
        }

        return answer.toString();
    }
}