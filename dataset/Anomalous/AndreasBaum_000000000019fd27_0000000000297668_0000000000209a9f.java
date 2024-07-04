import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= numberOfTestCases; caseNumber++) {
            String inputString = scanner.nextLine();
            char[] inputDigits = inputString.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digitChar : inputDigits) {
                int digit = Character.getNumericValue(digitChar);

                if (digit < currentDepth) {
                    result.append(generateBrackets(')', currentDepth - digit));
                } else if (digit > currentDepth) {
                    result.append(generateBrackets('(', digit - currentDepth));
                }
                result.append(digit);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                result.append(generateBrackets(')', currentDepth));
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String generateBrackets(char bracket, int count) {
        StringBuilder brackets = new StringBuilder();
        for (int i = 0; i < count; i++) {
            brackets.append(bracket);
        }
        return brackets.toString();
    }
}