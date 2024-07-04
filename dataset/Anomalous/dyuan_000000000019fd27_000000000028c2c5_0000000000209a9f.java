import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                String input = scanner.next();
                System.out.println("Case #" + i + ": " + generateParentheses(input));
            }
        }
    }

    private static String generateParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (char ch : input.toCharArray()) {
            int currentDigit = Character.getNumericValue(ch);

            if (currentDigit > previousDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
            } else if (currentDigit < previousDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
            }

            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(previousDigit));
        return result.toString();
    }
}