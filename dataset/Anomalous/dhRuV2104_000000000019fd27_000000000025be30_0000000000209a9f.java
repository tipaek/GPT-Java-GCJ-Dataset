import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            String result = generateParentheses(inputString);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String generateParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (char currentChar : s.toCharArray()) {
            int currentDigit = currentChar - '0';
            if (currentDigit > previousDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
            } else if (currentDigit < previousDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
            }
            result.append(currentChar);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(previousDigit));
        return result.toString();
    }
}