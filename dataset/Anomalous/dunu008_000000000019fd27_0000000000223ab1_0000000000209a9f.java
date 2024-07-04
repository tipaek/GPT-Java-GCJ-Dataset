import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String number = scanner.nextLine();
            processTestCase(i, number);
        }
    }

    private static void processTestCase(int testCaseNumber, String number) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < number.length(); index++) {
            int currentDigit = number.charAt(index) - '0';
            int previousDigit = index > 0 ? number.charAt(index - 1) - '0' : 0;
            int nextDigit = index < number.length() - 1 ? number.charAt(index + 1) - '0' : 0;

            appendOpeningBrackets(result, currentDigit, previousDigit);
            result.append(currentDigit);
            appendClosingBrackets(result, currentDigit, nextDigit, index, number.length());
        }

        System.out.println("Case #" + testCaseNumber + ": " + result.toString());
    }

    private static void appendOpeningBrackets(StringBuilder result, int currentDigit, int previousDigit) {
        for (int i = 0; i < currentDigit - previousDigit; i++) {
            result.append('(');
        }
    }

    private static void appendClosingBrackets(StringBuilder result, int currentDigit, int nextDigit, int index, int length) {
        for (int i = 0; i < currentDigit - nextDigit; i++) {
            result.append(')');
        }
        if (index == length - 1 && currentDigit != 0) {
            result.append(')');
        }
    }
}