import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char digitChar : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(digitChar);
                appendFormatted(result, previousDigit, currentDigit, digitChar);
                previousDigit = currentDigit;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static void appendFormatted(StringBuilder result, int previousDigit, int currentDigit, char digitChar) {
        if (previousDigit >= currentDigit) {
            result.insert(result.length() - currentDigit, digitChar);
        } else {
            StringBuilder formatted = new StringBuilder();

            for (int i = 0; i < currentDigit - previousDigit; i++) {
                formatted.append('(');
            }
            formatted.append(digitChar);
            for (int i = 0; i < currentDigit - previousDigit; i++) {
                formatted.append(')');
            }

            result.insert(result.length() - previousDigit, formatted.toString());
        }
    }
}