import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(System.out)) {
            int testCases = sc.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                String n = sc.next();
                String result = solve(n);
                pw.printf("Case #%d: %s%n", testCase, result);
                pw.flush();
            }
        }
    }

    private static String solve(String n) {
        StringBuilder result = new StringBuilder();
        int prevVal = 0;

        for (char c : n.toCharArray()) {
            int currVal = Character.getNumericValue(c);
            adjustParentheses(result, prevVal, currVal);
            result.append(c);
            prevVal = currVal;
        }
        adjustParentheses(result, prevVal, 0); // Close any remaining open parentheses

        return result.toString();
    }

    private static void adjustParentheses(StringBuilder result, int prevVal, int currVal) {
        while (prevVal < currVal) {
            result.append('(');
            prevVal++;
        }
        while (prevVal > currVal) {
            result.append(')');
            prevVal--;
        }
    }
}