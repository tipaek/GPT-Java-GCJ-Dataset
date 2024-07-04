import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numCases = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            String[] results = new String[numCases];
            for (int i = 0; i < numCases; i++) {
                String digits = scanner.nextLine();
                results[i] = formatCaseResult(digits, i + 1);
            }

            for (String result : results) {
                System.out.println(result);
            }
        }
    }

    private static String formatCaseResult(String digits, int caseNumber) {
        StringBuilder resultBuilder = new StringBuilder();
        int previousDigit = 0;

        for (int i = 0; i <= digits.length(); i++) {
            int currentDigit = (i < digits.length()) ? Character.getNumericValue(digits.charAt(i)) : 0;

            if (previousDigit < currentDigit) {
                resultBuilder.append("(".repeat(currentDigit - previousDigit));
            } else if (previousDigit > currentDigit) {
                resultBuilder.append(")".repeat(previousDigit - currentDigit));
            }

            if (i < digits.length()) {
                resultBuilder.append(currentDigit);
            }

            previousDigit = currentDigit;
        }

        return "Case #" + caseNumber + ": " + resultBuilder.toString();
    }
}