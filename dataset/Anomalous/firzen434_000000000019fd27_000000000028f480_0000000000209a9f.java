import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSE_PARENTHESIS = ')';

    private static String formatStringWithParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentNestingLevel = 0;

        if (input.charAt(0) != '0') {
            result.append(OPEN_PARENTHESIS);
            currentNestingLevel = 1;
        }

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int currentValue = currentChar - '0';

            if (currentValue > currentNestingLevel) {
                int difference = currentValue - currentNestingLevel;
                appendCharacters(result, difference, OPEN_PARENTHESIS);
                currentNestingLevel += difference;
            } else if (currentValue < currentNestingLevel) {
                int difference = currentNestingLevel - currentValue;
                appendCharacters(result, difference, CLOSE_PARENTHESIS);
                currentNestingLevel -= difference;
            }

            result.append(currentChar);
        }

        while (currentNestingLevel > 0) {
            result.append(CLOSE_PARENTHESIS);
            currentNestingLevel--;
        }

        return result.toString();
    }

    private static void appendCharacters(StringBuilder sb, int count, char character) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String result = formatStringWithParentheses(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}