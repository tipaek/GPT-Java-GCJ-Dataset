import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            short testCases = Short.parseShort(scanner.nextLine());
            for (int i = 0; i < testCases; i++) {
                String result = addParentheses(new StringBuilder(scanner.nextLine()));
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static String addParentheses(StringBuilder input) {
        StringBuilder result = new StringBuilder();
        short currentDepth = 0;
        short previousDigit = 0;

        for (int i = 0; i < input.length(); i++) {
            short currentDigit = Short.parseShort(String.valueOf(input.charAt(i)));
            if (currentDigit > previousDigit) {
                appendParentheses(result, '(', currentDigit - previousDigit);
            } else if (currentDigit < previousDigit) {
                appendParentheses(result, ')', previousDigit - currentDigit);
            }
            result.append(currentDigit);
            previousDigit = currentDigit;
        }
        appendParentheses(result, ')', previousDigit);
        return result.toString();
    }

    private static void appendParentheses(StringBuilder result, char parenthesis, short count) {
        for (int i = 0; i < count; i++) {
            result.append(parenthesis);
        }
    }
}