import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int test = 1; test <= numberOfTests; test++) {
            String inputString = scanner.next();
            System.out.printf("Case #%d: %s\n", test, generateBalancedParentheses(inputString));
        }
    }

    private static String generateBalancedParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int openParenthesesCount = 0;

        for (char character : input.toCharArray()) {
            int digit = Character.getNumericValue(character);

            while (openParenthesesCount < digit) {
                result.append("(");
                openParenthesesCount++;
            }

            while (openParenthesesCount > digit) {
                result.append(")");
                openParenthesesCount--;
            }

            result.append(digit);
        }

        while (openParenthesesCount > 0) {
            result.append(")");
            openParenthesesCount--;
        }

        return result.toString();
    }
}