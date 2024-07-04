import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            System.out.println("Case #" + testCase + ": " + processString(input));
        }
    }

    private static String processString(String input) {
        if (input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char previousChar = '0';

        for (char currentChar : input.toCharArray()) {
            int difference = currentChar - previousChar;
            if (difference > 0) {
                result.append("(".repeat(difference));
            } else if (difference < 0) {
                result.append(")".repeat(-difference));
            }
            result.append(currentChar);
            previousChar = currentChar;
        }

        int closingBrackets = input.charAt(input.length() - 1) - '0';
        result.append(")".repeat(closingBrackets));

        return result.toString();
    }
}