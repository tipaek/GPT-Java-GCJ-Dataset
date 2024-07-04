import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String inputString = scanner.next();
            processParentheses(inputString, caseIndex);
        }
    }

    private static void processParentheses(String inputString, int caseIndex) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < inputString.length(); i++) {
            int digit = inputString.charAt(i) - '0';

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }

            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println("Case #" + caseIndex + ": " + result.toString());
    }
}