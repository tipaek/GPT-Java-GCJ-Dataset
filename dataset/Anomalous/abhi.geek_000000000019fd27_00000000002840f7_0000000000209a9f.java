import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = Integer.parseInt(scanner.nextLine().trim());
        for (int testCaseCounter = 1; testCaseCounter <= totalTestCases; testCaseCounter++) {
            String input = scanner.nextLine().trim();
            System.out.println("Case #" + testCaseCounter + ": " + addBraces(input));
        }
    }

    private static String addBraces(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        int openBracesCount = 0;
        int previousDigit = 0;

        for (char ch : input.toCharArray()) {
            int currentDigit = ch - '0';

            while (openBracesCount < currentDigit) {
                result.append('(');
                openBracesCount++;
            }

            while (openBracesCount > currentDigit) {
                result.append(')');
                openBracesCount--;
            }

            result.append(ch);
            previousDigit = currentDigit;
        }

        while (openBracesCount > 0) {
            result.append(')');
            openBracesCount--;
        }

        return result.toString();
    }
}