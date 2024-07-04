import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next().trim();
            String result = processString(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processString(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int openParentheses = 0;
        int previousDigit = 0;

        for (char currentChar : input.toCharArray()) {
            int currentDigit = Character.getNumericValue(currentChar);
            int difference = currentDigit - previousDigit;

            if (difference > 0) {
                for (int j = 0; j < difference; j++) {
                    resultBuilder.append('(');
                }
            } else if (difference < 0) {
                for (int j = 0; j < -difference; j++) {
                    resultBuilder.append(')');
                }
            }

            resultBuilder.append(currentChar);
            openParentheses += difference;
            previousDigit = currentDigit;
        }

        while (openParentheses > 0) {
            resultBuilder.append(')');
            openParentheses--;
        }

        return resultBuilder.toString();
    }
}