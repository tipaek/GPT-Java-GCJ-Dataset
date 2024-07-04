import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        char openParen = '(';
        char closeParen = ')';

        int testCases = input.nextInt(); // number of test cases

        for (int i = 0; i < testCases; i++) {
            StringBuilder result = new StringBuilder();

            String inputString = input.next();
            char[] digits = inputString.toCharArray();

            // Append opening parentheses for the first digit
            for (int j = 0; j < digits[0] - '0'; j++) {
                result.append(openParen);
            }

            result.append(digits[0]); // Append the first digit

            for (int j = 0; j < inputString.length() - 1; j++) {
                int currentDigit = digits[j] - '0';
                int nextDigit = digits[j + 1] - '0';

                if (nextDigit == currentDigit) {
                    result.append(digits[j + 1]);
                } else if (nextDigit > currentDigit) {
                    // Append closing parentheses for the current digit
                    for (int k = 0; k < currentDigit; k++) {
                        result.append(closeParen);
                    }
                    // Append opening parentheses for the next digit
                    for (int k = 0; k < nextDigit; k++) {
                        result.append(openParen);
                    }
                    result.append(digits[j + 1]);
                } else {
                    // Append closing parentheses for the difference between current and next digit
                    for (int k = 0; k < currentDigit - nextDigit; k++) {
                        result.append(closeParen);
                    }
                    result.append(digits[j + 1]);
                }
            }

            // Append closing parentheses for the last digit
            for (int j = 0; j < digits[digits.length - 1] - '0'; j++) {
                result.append(closeParen);
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        input.close();
    }
}