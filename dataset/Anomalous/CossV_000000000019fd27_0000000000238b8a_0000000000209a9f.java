import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousNumber = 0;

            for (char c : input.toCharArray()) {
                int currentNumber = c - '0';

                // Add opening parentheses
                while (previousNumber < currentNumber) {
                    result.append('(');
                    previousNumber++;
                }

                // Add closing parentheses
                while (previousNumber > currentNumber) {
                    result.append(')');
                    previousNumber--;
                }

                // Append the current number
                result.append(currentNumber);
            }

            // Close any remaining open parentheses
            while (previousNumber > 0) {
                result.append(')');
                previousNumber--;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}