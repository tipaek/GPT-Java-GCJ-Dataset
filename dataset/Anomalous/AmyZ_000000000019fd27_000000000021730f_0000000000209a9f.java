import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String number = scanner.nextLine();
            System.out.println("Case #" + i + ": " + generateNestedParentheses(number));
        }
    }

    public static String generateNestedParentheses(String number) {
        StringBuilder result = new StringBuilder();
        char[] digits = number.toCharArray();
        int[] openBrackets = new int[digits.length];
        int[] closeBrackets = new int[digits.length];
        int currentDepth = 0;

        for (int i = 0; i < digits.length; i++) {
            int digitValue = digits[i] - '0';
            if (digitValue > currentDepth) {
                openBrackets[i] = digitValue - currentDepth;
            } else if (digitValue < currentDepth) {
                closeBrackets[i] = currentDepth - digitValue;
            }
            currentDepth = digitValue;
        }

        for (int i = 0; i < digits.length; i++) {
            appendBrackets(result, openBrackets[i], '(');
            appendBrackets(result, closeBrackets[i], ')');
            result.append(digits[i]);
        }

        appendBrackets(result, currentDepth, ')');

        return result.toString();
    }

    private static void appendBrackets(StringBuilder result, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
    }
}