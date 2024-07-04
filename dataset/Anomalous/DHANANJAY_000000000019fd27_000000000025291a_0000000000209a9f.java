import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(input.charAt(0));

            // Append initial opening parentheses
            for (int j = 0; j < previousDigit; j++) {
                result.append('(');
            }
            result.append(previousDigit);

            // Process the rest of the digits
            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        result.append('(');
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        result.append(')');
                    }
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            // Append closing parentheses for the last digit
            for (int j = 0; j < previousDigit; j++) {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}