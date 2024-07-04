import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            char[] characters = input.toCharArray();
            int currentDigit = characters[0] - '0';

            // Append opening brackets for the first digit
            for (int j = 0; j < currentDigit; j++) {
                result.append('(');
                openBrackets++;
            }
            result.append(currentDigit);

            // Process the rest of the digits
            for (int k = 1; k < characters.length; k++) {
                int nextDigit = characters[k] - '0';
                int previousDigit = characters[k - 1] - '0';

                if (previousDigit < nextDigit) {
                    for (int j = 0; j < nextDigit - previousDigit; j++) {
                        result.append('(');
                        openBrackets++;
                    }
                } else if (previousDigit > nextDigit) {
                    for (int j = 0; j < previousDigit - nextDigit; j++) {
                        result.append(')');
                        openBrackets--;
                    }
                }
                result.append(nextDigit);
            }

            // Close any remaining open brackets
            for (int j = 0; j < openBrackets; j++) {
                result.append(')');
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}