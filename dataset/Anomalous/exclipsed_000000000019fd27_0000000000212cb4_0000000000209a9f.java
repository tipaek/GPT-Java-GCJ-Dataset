import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final int MOD = 1000000007;
    private static final int INT_MAX = 1000000000;
    private static final int INT_MIN = -1000000000;
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    private static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            String input = reader.readLine();
            int[] digits = new int[input.length()];

            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }

            StringBuilder result = new StringBuilder();
            appendOpenParentheses(result, digits[0]);
            result.append(digits[0]);

            for (int i = 1; i < digits.length; i++) {
                if (digits[i] > digits[i - 1]) {
                    appendOpenParentheses(result, digits[i] - digits[i - 1]);
                } else if (digits[i] < digits[i - 1]) {
                    appendCloseParentheses(result, digits[i - 1] - digits[i]);
                }
                result.append(digits[i]);
            }
            appendCloseParentheses(result, digits[digits.length - 1]);

            System.out.print(result.toString());
            if (t != T) {
                System.out.println();
            }
        }
        reader.close();
    }

    private static void appendOpenParentheses(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append('(');
        }
    }

    private static void appendCloseParentheses(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(')');
        }
    }
}