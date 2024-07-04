import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            String number = scanner.next();
            processTestCase(i, number);
        }
    }

    public static void processTestCase(int index, String number) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (int i = 0; i < number.length(); i++) {
            int currentDigit = Character.getNumericValue(number.charAt(i));

            if (currentDigit > previousDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
            } else if (currentDigit < previousDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
            }

            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(previousDigit));
        System.out.println("Case #" + index + ": " + result);
    }
}