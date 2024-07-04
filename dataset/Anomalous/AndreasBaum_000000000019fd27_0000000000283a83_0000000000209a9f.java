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
            char[] digitsArray = inputString.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digitChar : digitsArray) {
                int digitValue = Character.getNumericValue(digitChar);

                if (digitValue < currentDepth) {
                    result.append(repeatCharacters(')', currentDepth - digitValue));
                } else if (digitValue > currentDepth) {
                    result.append(repeatCharacters('(', digitValue - currentDepth));
                }
                result.append(digitValue);
                currentDepth = digitValue;
            }

            if (currentDepth > 0) {
                result.append(repeatCharacters(')', currentDepth));
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String repeatCharacters(char character, int count) {
        StringBuilder repeatedString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedString.append(character);
        }
        return repeatedString.toString();
    }
}