import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParenthesesCount = 0;
            final int length = input.length();

            for (int i = 0; i < length; i++) {
                char currentChar = input.charAt(i);
                int currentNum = currentChar - '0';

                while (openParenthesesCount > currentNum) {
                    result.append(')');
                    openParenthesesCount--;
                }
                while (openParenthesesCount < currentNum) {
                    result.append('(');
                    openParenthesesCount++;
                }

                result.append(currentChar);
            }

            while (openParenthesesCount > 0) {
                result.append(')');
                openParenthesesCount--;
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
        }
    }
}