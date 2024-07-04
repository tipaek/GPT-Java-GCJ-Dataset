import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();
            String inputString = scanner.next();
            for (int index = 0; index < inputString.length(); index++) {
                int digit = Character.getNumericValue(inputString.charAt(index));
                if (currentDepth == digit) {
                    result.append(digit);
                } else if (currentDepth < digit) {
                    result.append(generateParentheses(true, digit - currentDepth));
                    result.append(digit);
                    currentDepth = digit;
                } else {
                    result.append(generateParentheses(false, currentDepth - digit));
                    result.append(digit);
                    currentDepth = digit;
                }
            }
            result.append(generateParentheses(false, currentDepth));
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    private static String generateParentheses(boolean opening, int count) {
        StringBuilder parentheses = new StringBuilder();
        char parenChar = opening ? '(' : ')';
        for (int i = 0; i < count; i++) {
            parentheses.append(parenChar);
        }
        return parentheses.toString();
    }
}