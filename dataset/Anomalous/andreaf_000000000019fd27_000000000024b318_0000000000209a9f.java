import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                String input = scanner.next();
                System.out.printf("Case #%d: %s%n", i + 1, insertParentheses(input));
            }
        }
    }

    private static String insertParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentOpen = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            int difference = digit - currentOpen;

            if (difference > 0) {
                result.append("(".repeat(difference));
            } else if (difference < 0) {
                result.append(")".repeat(-difference));
            }

            result.append(digit);
            currentOpen = digit;
        }

        if (currentOpen > 0) {
            result.append(")".repeat(currentOpen));
        }

        return result.toString();
    }
}