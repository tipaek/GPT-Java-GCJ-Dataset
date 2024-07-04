import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String output = processInput(input);
            System.out.printf("Case #%d: %s\n", i, output);
        }
    }

    private static String processInput(String input) {
        int currentNesting = 0;
        StringBuilder result = new StringBuilder();

        for (char digit : input.toCharArray()) {
            int value = Character.getNumericValue(digit);
            int difference = value - currentNesting;

            appendParentheses(difference, result);
            result.append(digit);

            currentNesting = value;
        }

        appendParentheses(-currentNesting, result);
        return result.toString();
    }

    private static void appendParentheses(int count, StringBuilder builder) {
        char parenthesis = count > 0 ? '(' : ')';
        for (int i = 0; i < Math.abs(count); i++) {
            builder.append(parenthesis);
        }
    }
}