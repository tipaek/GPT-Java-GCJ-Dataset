import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String inputString = scanner.nextLine();
            char[] digits = inputString.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digit : digits) {
                int numericValue = Character.getNumericValue(digit);

                if (numericValue > currentDepth) {
                    result.append("(".repeat(numericValue - currentDepth));
                } else if (numericValue < currentDepth) {
                    result.append(")".repeat(currentDepth - numericValue));
                }

                result.append(numericValue);
                currentDepth = numericValue;
            }

            if (currentDepth > 0) {
                result.append(")".repeat(currentDepth));
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}