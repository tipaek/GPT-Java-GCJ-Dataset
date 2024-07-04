import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        List<String> results = new ArrayList<>();

        for (int i = 1; i <= numberOfTestCases; i++) {
            String input = scanner.nextLine().trim();
            while (input.isEmpty()) {
                input = scanner.nextLine().trim();
            }
            results.add(processInput(input, i));
        }

        results.forEach(System.out::println);
    }

    private static String processInput(String input, int testCaseNumber) {
        int length = input.length();
        int[][] parenthesesArray = new int[length][3];

        for (int i = 0; i < length; i++) {
            int number = Character.getNumericValue(input.charAt(i));
            parenthesesArray[i][0] = number;
            parenthesesArray[i][1] = number;
            parenthesesArray[i][2] = number;
        }

        for (int i = 1; i < length; i++) {
            int diff = parenthesesArray[i][1] - parenthesesArray[i - 1][2];
            if (diff == 0) {
                parenthesesArray[i - 1][2] = 0;
                parenthesesArray[i][1] = 0;
            } else if (diff > 0) {
                parenthesesArray[i - 1][2] = 0;
                parenthesesArray[i][1] = diff;
            } else {
                parenthesesArray[i][1] = 0;
                parenthesesArray[i - 1][2] = -diff;
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            resultBuilder.append(generateParentheses(parenthesesArray[i][1], true))
                         .append(parenthesesArray[i][0])
                         .append(generateParentheses(parenthesesArray[i][2], false));
        }

        return formatResult(testCaseNumber, resultBuilder.toString());
    }

    private static String generateParentheses(int count, boolean isOpening) {
        if (count == 0) {
            return "";
        }
        StringBuilder parentheses = new StringBuilder();
        char parenthesisChar = isOpening ? '(' : ')';
        for (int i = 0; i < count; i++) {
            parentheses.append(parenthesisChar);
        }
        return parentheses.toString();
    }

    private static String formatResult(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}