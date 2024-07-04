import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfCases = scanner.nextLong();

        for (long caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String inputLine = scanner.next();
            StringBuilder result = new StringBuilder();

            int currentDepth = 0;
            for (int i = 0; i < inputLine.length(); i++) {
                int currentDigit = Character.getNumericValue(inputLine.charAt(i));

                if (currentDigit > currentDepth) {
                    result.append(repeatChar(currentDigit - currentDepth, '('));
                    currentDepth = currentDigit;
                } else if (currentDigit < currentDepth) {
                    result.append(repeatChar(currentDepth - currentDigit, ')'));
                    currentDepth = currentDigit;
                }
                result.append(currentDigit);
            }

            if (currentDepth > 0) {
                result.append(repeatChar(currentDepth, ')'));
            }

            System.out.printf("Case #%d: %s%n", caseIndex, result.toString());
        }

        scanner.close();
    }

    private static String repeatChar(int count, char character) {
        StringBuilder repeatedChars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedChars.append(character);
        }
        return repeatedChars.toString();
    }
}