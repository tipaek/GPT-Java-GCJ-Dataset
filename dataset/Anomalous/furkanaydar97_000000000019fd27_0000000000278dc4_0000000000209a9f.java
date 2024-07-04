import java.util.Scanner;

public class Solution {
    private static String solve(String input) {
        StringBuilder edited = new StringBuilder("0").append(input).append("0");
        StringBuilder result = new StringBuilder();
        int length = edited.length();

        for (int i = 0; i < length - 1; i++) {
            char currentDigit = edited.charAt(i);
            char nextDigit = edited.charAt(i + 1);
            result.append(currentDigit);

            int difference = nextDigit - currentDigit;
            if (difference > 0) {
                result.append("(".repeat(difference));
            } else {
                result.append(")".repeat(-difference));
            }
        }

        return result.substring(1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            System.out.println("Case #" + (i + 1) + ": " + solve(input));
        }
    }
}