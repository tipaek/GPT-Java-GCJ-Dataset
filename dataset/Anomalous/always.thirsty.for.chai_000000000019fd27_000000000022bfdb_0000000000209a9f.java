import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = testCases;

        while (testCases-- > 0) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            int initialDigit = input.charAt(0) - '0';

            // Add opening parentheses for the first digit
            for (int i = 0; i < initialDigit; i++) {
                result.append('(');
            }
            result.append(input.charAt(0));
            openParentheses = initialDigit;

            // Process the rest of the digits
            for (int i = 1; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                int currentDigit = currentChar - '0';

                if (currentDigit > openParentheses) {
                    // Add opening parentheses
                    for (int j = 0; j < currentDigit - openParentheses; j++) {
                        result.append('(');
                    }
                } else if (currentDigit < openParentheses) {
                    // Add closing parentheses
                    for (int j = 0; j < openParentheses - currentDigit; j++) {
                        result.append(')');
                    }
                }

                result.append(currentChar);
                openParentheses = currentDigit;
            }

            // Close any remaining open parentheses
            for (int i = 0; i < openParentheses; i++) {
                result.append(')');
            }

            System.out.println("Case #" + (caseNumber - testCases) + ": " + result.toString());
        }

        scanner.close();
    }
}