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
        short previousDepth = 0;
        short currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            short digit = Short.parseShort(String.valueOf(input.charAt(i)));
            if (i == 0 || currentDepth == 0) {
                currentDepth += digit;
                prependParentheses(result, digit);
                result.append(digit);
                previousDepth = digit;
                if (i == input.length() - 1) {
                    appendParentheses(result, currentDepth);
                }
                continue;
            }

            if (digit == previousDepth) {
                result.append(digit);
                previousDepth = digit;
                continue;
            }

            if (digit < previousDepth) {
                appendParentheses(result, (short) (previousDepth - digit));
                result.append(digit);
                currentDepth -= (previousDepth - digit);
                previousDepth = digit;
                continue;
            }

            if (digit > previousDepth) {
                result.append(digit);
                appendParentheses(result, currentDepth);
                currentDepth = 0;
                previousDepth = digit;
                continue;
            }

            if (i == input.length() - 1) {
                result.append(digit);
                appendParentheses(result, currentDepth);
                currentDepth = 0;
                previousDepth = digit;
            }
        }

        return result.toString();
    }

    private static void prependParentheses(StringBuilder result, short count) {
        for (int i = 0; i < count; i++) {
            result.insert(0, '(');
        }
    }

    private static void appendParentheses(StringBuilder result, short count) {
        for (int i = 0; i < count; i++) {
            result.append(')');
        }
    }
}