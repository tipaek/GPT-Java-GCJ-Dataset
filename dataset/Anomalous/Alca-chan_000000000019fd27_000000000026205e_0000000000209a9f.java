import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numOfCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (numOfCases <= 0) {
                return;
            }

            StringBuilder result = new StringBuilder();
            for (int caseIndex = 0; caseIndex < numOfCases; caseIndex++) {
                String input = scanner.nextLine();
                result.append("Case #").append(caseIndex + 1).append(": ");

                int openParentheses = 0;
                for (int i = 0; i < input.length(); i++) {
                    int currentDigit = Character.getNumericValue(input.charAt(i));
                    while (currentDigit > openParentheses) {
                        result.append("(");
                        openParentheses++;
                    }
                    while (currentDigit < openParentheses) {
                        result.append(")");
                        openParentheses--;
                    }
                    result.append(input.charAt(i));
                }

                // Close any remaining open parentheses
                while (openParentheses > 0) {
                    result.append(")");
                    openParentheses--;
                }

                result.append("\n");
            }
            System.out.print(result);
        }
    }
}