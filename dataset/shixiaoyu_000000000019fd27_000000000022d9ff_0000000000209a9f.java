
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int testCases = s.nextInt();
        s.nextLine();  // skip to next line
        int caseNum = 1;
        Solution nestingDepth = new Solution();

        while (caseNum <= testCases) {
            String n = s.nextLine();

            System.out.println(String.format("Case #%d: %s", caseNum, nestingDepth.minBrackets(n)));

            caseNum++;
        }
    }

    private String minBrackets(String s) {
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        if (digits == null || digits.length == 0) {
            return null;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits[0]; i++) {
            stack.push('(');
            sb.append("(");
        }

        sb.append(digits[0]);

        for (int i = 1; i < digits.length; i++) {
            if (digits[i] > digits[i - 1]) {
                for (int k = 0; k < digits[i] - digits[i - 1]; k++) {
                    stack.push('(');
                    sb.append("(");
                }
                sb.append(digits[i]);
            } else if (digits[i] < digits[i - 1]) {
                for (int k = 0; k < digits[i - 1] - digits[i]; k++) {
                    stack.pop();
                    sb.append(")");
                }
            }

            sb.append(digits[i]);
        }

        while (!stack.isEmpty()) {
            stack.pop();
            sb.append(")");
        }

        return sb.toString();
    }
}
