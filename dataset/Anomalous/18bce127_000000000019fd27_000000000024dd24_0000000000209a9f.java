import java.util.Scanner;

public class ParenthesesFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            char[] digits = input.toCharArray();

            // Add opening parentheses based on the first digit
            int currentDepth = digits[0] - '0';
            for (int i = 0; i < currentDepth; i++) {
                output.append('(');
            }

            // Process each digit
            for (int i = 0; i < digits.length; i++) {
                output.append(digits[i]);

                // Determine the number of parentheses to add or remove
                int nextDepth = (i < digits.length - 1) ? digits[i + 1] - '0' : 0;
                while (currentDepth < nextDepth) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > nextDepth) {
                    output.append(')');
                    currentDepth--;
                }
            }

            // Close any remaining open parentheses
            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNumber + ": " + output);
        }

        scanner.close();
    }
}