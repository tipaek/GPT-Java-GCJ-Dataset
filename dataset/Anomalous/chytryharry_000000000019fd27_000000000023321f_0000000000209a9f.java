import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputLine = scanner.next();
            System.out.println("Case #" + caseNumber + ": " + generateParentheses(inputLine));
        }
    }

    private static String generateParentheses(String inputLine) {
        StringBuilder result = new StringBuilder();
        int currentOpenParens = 0;

        for (int i = 0; i < inputLine.length(); i++) {
            int digit = Character.getNumericValue(inputLine.charAt(i));
            if (i == 0) {
                appendParentheses(result, digit);
                result.append(digit);
                currentOpenParens = digit;
            } else {
                int difference = digit - currentOpenParens;
                if (difference > 0) {
                    appendParentheses(result, difference);
                } else if (difference < 0) {
                    appendParentheses(result, difference);
                }
                result.append(digit);
                currentOpenParens = digit;
            }
        }

        appendParentheses(result, -currentOpenParens);
        return result.toString();
    }

    private static void appendParentheses(StringBuilder sb, int count) {
        char parenthesis = count > 0 ? '(' : ')';
        for (int i = 0; i < Math.abs(count); i++) {
            sb.append(parenthesis);
        }
    }
}