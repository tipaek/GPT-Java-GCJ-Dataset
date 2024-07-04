import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder(input);

            int adjustment = 0;
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                int digitValue = Character.getNumericValue(currentChar);

                if (digitValue > 0) {
                    StringBuilder leftParentheses = new StringBuilder();
                    StringBuilder rightParentheses = new StringBuilder();

                    for (int j = 0; j < digitValue; j++) {
                        leftParentheses.append("(");
                        rightParentheses.append(")");
                    }

                    result.insert(i + adjustment, leftParentheses);
                    adjustment += digitValue;
                    result.insert(i + adjustment + 1, rightParentheses);
                    adjustment += digitValue;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}