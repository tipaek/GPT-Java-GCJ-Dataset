import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in); PrintWriter output = new PrintWriter(System.out)) {
            int T = input.nextInt();
            for (int i = 0; i < T; i++) {
                String result = solve(input.next().toCharArray());
                output.printf("Case #%d: %s%n", (i + 1), result);
                output.flush();
            }
        }
    }

    public static String solve(char[] str) {
        StringBuilder builder = new StringBuilder();
        int length = str.length;

        for (int i = 0; i <= length; i++) {
            if (i == 0) {
                adjustParentheses(builder, '0', str[i]);
                builder.append(str[i]);
            } else if (i == length) {
                adjustParentheses(builder, str[i - 1], '0');
            } else {
                adjustParentheses(builder, str[i - 1], str[i]);
                builder.append(str[i]);
            }
        }

        return builder.toString();
    }

    public static void adjustParentheses(StringBuilder builder, char previous, char current) {
        int prevValue = previous - '0';
        int currValue = current - '0';
        int difference = Math.abs(prevValue - currValue);
        char parenthesis = prevValue < currValue ? '(' : ')';

        for (int i = 0; i < difference; i++) {
            builder.append(parenthesis);
        }
    }
}