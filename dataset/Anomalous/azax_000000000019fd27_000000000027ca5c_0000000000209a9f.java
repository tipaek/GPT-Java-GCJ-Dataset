import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String inputLine = scanner.nextLine();
            int[] digits = new int[inputLine.length()];

            for (int i = 0; i < inputLine.length(); i++) {
                digits[i] = Character.getNumericValue(inputLine.charAt(i));
            }

            String result = formatWithParentheses(digits);
            System.out.println("Case #" + caseIndex + ": " + result);
        }

        scanner.close();
    }

    private static String formatWithParentheses(int[] digits) {
        StringBuilder resultBuilder = new StringBuilder();

        int previousDigit = 0;
        for (int digit : digits) {
            while (previousDigit < digit) {
                resultBuilder.append('(');
                previousDigit++;
            }
            while (previousDigit > digit) {
                resultBuilder.append(')');
                previousDigit--;
            }
            resultBuilder.append(digit);
        }

        while (previousDigit > 0) {
            resultBuilder.append(')');
            previousDigit--;
        }

        return resultBuilder.toString();
    }
}