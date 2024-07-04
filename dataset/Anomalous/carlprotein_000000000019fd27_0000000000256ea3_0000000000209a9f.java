import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            String numberString = scanner.next();
            processTestCase(i, numberString);
        }
    }

    public static void processTestCase(int index, String numberString) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (int i = 0; i < numberString.length(); i++) {
            int currentDigit = Character.getNumericValue(numberString.charAt(i));
            int openBracketsNeeded = Math.max(0, currentDigit - previousDigit);
            int closeBracketsNeeded = Math.max(0, previousDigit - currentDigit);

            for (int j = 0; j < closeBracketsNeeded; j++) {
                result.append(')');
            }
            for (int j = 0; j < openBracketsNeeded; j++) {
                result.append('(');
            }

            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        for (int i = 0; i < previousDigit; i++) {
            result.append(')');
        }

        System.out.println("Case #" + index + ": " + result.toString());
    }
}