package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long testCases = scanner.nextLong();
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            String result = calculateNestingDepth(input);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));

            // Open parentheses
            int openParentheses = digit - currentDepth;
            if (openParentheses > 0) {
                result.append(repeatCharacter(openParentheses, '('));
                currentDepth += openParentheses;
            }

            result.append(digit);

            // Close parentheses
            int closeParentheses = 0;
            if (i < input.length() - 1) {
                int nextDigit = Character.getNumericValue(input.charAt(i + 1));
                closeParentheses = Math.max(0, digit - nextDigit);
            } else {
                closeParentheses = currentDepth;
            }
            if (closeParentheses > 0) {
                result.append(repeatCharacter(closeParentheses, ')'));
                currentDepth -= closeParentheses;
            }
        }

        return result.toString();
    }

    private static String repeatCharacter(int count, char character) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
        return builder.toString();
    }
}