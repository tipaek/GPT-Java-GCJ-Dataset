import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        for (int caseNumber = 1; caseNumber <= numberOfTestCases; caseNumber++) {
            String input = scanner.nextLine();
            char[] characters = input.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char character : characters) {
                int digit = Character.getNumericValue(character);

                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                }

                result.append(digit);
                currentDepth = digit;
            }

            result.append(")".repeat(currentDepth)); // Close any remaining open parentheses

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}