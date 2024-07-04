import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            processNestingDepth(input, i);
        }
    }

    private static void processNestingDepth(String input, int testCaseNumber) {
        StringBuilder result = new StringBuilder();
        input = "0" + input + "0";

        for (int i = 0; i < input.length() - 1; i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            int nextDigit = Character.getNumericValue(input.charAt(i + 1));
            int difference = currentDigit - nextDigit;

            if (difference > 0) {
                result.append(")".repeat(difference));
            } else if (difference < 0) {
                result.append("(".repeat(-difference));
            }

            if (i < input.length() - 2) {
                result.append(input.charAt(i + 1));
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + result.toString());
    }
}