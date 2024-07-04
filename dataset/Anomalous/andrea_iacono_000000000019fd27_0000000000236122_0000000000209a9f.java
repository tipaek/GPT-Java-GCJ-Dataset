package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            long testCases = scanner.nextLong();
            scanner.nextLine(); // Consume the newline

            for (int i = 1; i <= testCases; i++) {
                String input = scanner.nextLine();
                String result = calculateNestingDepth(input);
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}