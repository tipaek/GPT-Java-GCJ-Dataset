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
            int openParentheses = 0;
            final int inputLength = input.length();

            for (int i = 0; i < inputLength; i++) {
                char currentChar = input.charAt(i);
                int currentNum = currentChar - '0';

                while (openParentheses > currentNum) {
                    result.append(')');
                    openParentheses--;
                }
                while (openParentheses < currentNum) {
                    result.append('(');
                    openParentheses++;
                }
                while (i < inputLength && input.charAt(i) == currentChar) {
                    result.append(currentChar);
                    i++;
                }
                i--;
            }
            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }
            System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
        }
    }
}