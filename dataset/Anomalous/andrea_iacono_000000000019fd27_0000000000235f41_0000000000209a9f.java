package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            long testCases = scanner.nextLong();
            for (int i = 0; i < testCases; i++) {
                String input = scanner.next();
                String result = calculateNestingDepth(input);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));

            // Open new parentheses if needed
            result.append(repeatChar('(', digit - currentDepth));
            currentDepth = digit;

            // Append the current digit
            result.append(digit);

            // Determine the depth for closing parentheses
            int nextDigit = (i < input.length() - 1) ? Character.getNumericValue(input.charAt(i + 1)) : 0;
            result.append(repeatChar(')', currentDepth - nextDigit));
            currentDepth = nextDigit;
        }
        return result.toString();
    }

    private static String repeatChar(char character, int times) {
        if (times <= 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder(times);
        for (int i = 0; i < times; i++) {
            builder.append(character);
        }
        return builder.toString();
    }
}