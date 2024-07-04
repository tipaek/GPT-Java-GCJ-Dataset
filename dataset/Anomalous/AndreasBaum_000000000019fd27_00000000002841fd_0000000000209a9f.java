import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after the integer input

        for (int caseNumber = 1; caseNumber <= numberOfTestCases; caseNumber++) {
            String inputString = scanner.nextLine();
            char[] inputDigits = inputString.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digitChar : inputDigits) {
                int digitValue = Character.getNumericValue(digitChar);

                if (digitValue < currentDepth) {
                    result.append(repeat(")", currentDepth - digitValue));
                } else if (digitValue > currentDepth) {
                    result.append(repeat("(", digitValue - currentDepth));
                }
                result.append(digitValue);
                currentDepth = digitValue;
            }

            if (currentDepth > 0) {
                result.append(repeat(")", currentDepth));
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String repeat(String str, int count) {
        StringBuilder repeatedString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedString.append(str);
        }
        return repeatedString.toString();
    }
}