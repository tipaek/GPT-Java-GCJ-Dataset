import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(input.charAt(0));

            // Add initial opening parentheses
            result.append("(".repeat(previousDigit));
            result.append(input.charAt(0));

            for (int j = 1; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    // Add opening parentheses
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    // Add closing parentheses
                    result.append(")".repeat(-difference));
                }

                result.append(input.charAt(j));
                previousDigit = currentDigit;
            }

            // Close any remaining open parentheses
            result.append(")".repeat(previousDigit));

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}