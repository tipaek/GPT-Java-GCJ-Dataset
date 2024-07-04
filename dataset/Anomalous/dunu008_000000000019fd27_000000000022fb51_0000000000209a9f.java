import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String numberString = scanner.nextLine();
            processTestCase(i, numberString);
        }

        scanner.close();
    }

    private static void processTestCase(int testCaseNumber, String numberString) {
        StringBuilder result = new StringBuilder();

        int previousDigit = 0;
        for (char digitChar : numberString.toCharArray()) {
            int currentDigit = Character.getNumericValue(digitChar);

            while (previousDigit < currentDigit) {
                result.append('(');
                previousDigit++;
            }

            while (previousDigit > currentDigit) {
                result.append(')');
                previousDigit--;
            }

            result.append(currentDigit);
        }

        while (previousDigit > 0) {
            result.append(')');
            previousDigit--;
        }

        System.out.println("Case #" + testCaseNumber + ": " + result.toString());
    }
}