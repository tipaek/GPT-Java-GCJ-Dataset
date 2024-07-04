import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        int caseNumber = 1;

        while (testCases > 0) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (i == 0) {
                    appendBrackets(result, currentDigit, openBrackets);
                    openBrackets = currentDigit;
                } else {
                    int previousDigit = Character.getNumericValue(input.charAt(i - 1));
                    adjustBrackets(result, currentDigit, previousDigit);
                    openBrackets += currentDigit - previousDigit;
                }

                result.append(currentDigit);
            }

            closeRemainingBrackets(result, openBrackets);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
            testCases--;
        }

        scanner.close();
    }

    private static void appendBrackets(StringBuilder result, int currentDigit, int openBrackets) {
        for (int j = 0; j < currentDigit; j++) {
            result.append('(');
        }
    }

    private static void adjustBrackets(StringBuilder result, int currentDigit, int previousDigit) {
        if (currentDigit > previousDigit) {
            for (int j = 0; j < currentDigit - previousDigit; j++) {
                result.append('(');
            }
        } else if (currentDigit < previousDigit) {
            for (int j = 0; j < previousDigit - currentDigit; j++) {
                result.append(')');
            }
        }
    }

    private static void closeRemainingBrackets(StringBuilder result, int openBrackets) {
        for (int j = 0; j < openBrackets; j++) {
            result.append(')');
        }
    }
}