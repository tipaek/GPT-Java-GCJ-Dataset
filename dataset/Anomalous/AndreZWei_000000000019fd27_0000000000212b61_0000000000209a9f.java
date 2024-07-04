import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + generateParentheses(input));
        }
    }

    private static String generateParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (char character : input.toCharArray()) {
            int currentDigit = character - '0';
            if (currentDigit > previousDigit) {
                for (int j = previousDigit; j < currentDigit; j++) {
                    result.append('(');
                }
            } else if (currentDigit < previousDigit) {
                for (int j = currentDigit; j < previousDigit; j++) {
                    result.append(')');
                }
            }
            result.append(character);
            previousDigit = currentDigit;
        }

        for (int j = previousDigit; j > 0; j--) {
            result.append(')');
        }

        return result.toString();
    }
}