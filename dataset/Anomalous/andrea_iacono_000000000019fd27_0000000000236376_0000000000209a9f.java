package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.next();
            String result = calculateNestingDepth(inputString);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String calculateNestingDepth(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            // Open parentheses
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }

            // Close parentheses
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        // Close any remaining open parentheses
        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}