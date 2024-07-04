import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 1; i <= numOfCases; i++) {
            String s = scanner.next();
            System.out.println("Case #" + i + ": " + formatStringWithParentheses(s));
        }
    }

    private static String formatStringWithParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);

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

        return result.toString();
    }
}