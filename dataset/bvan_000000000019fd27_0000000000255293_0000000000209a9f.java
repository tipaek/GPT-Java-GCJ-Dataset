import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(scanner.readLine());
        for (int t = 1; t <= tests; t++) {
            String s = scanner.readLine();
            String res = minParenthesisedString(s);
            System.out.println(String.format("Case #%d: %s", t, res));
        }
    }

    private static String minParenthesisedString(String s) {
        int prev = 0;

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int current = getInt(s, i);
            appendParentheses(res, prev, current);
            res.append(current);
            prev = current;
        }
        appendParentheses(res, prev, 0);

        return res.toString();
    }

    private static void appendParentheses(StringBuilder res, int prev, int current) {
        int diff = prev - current;
        if (diff > 0) {
            appendChars(res, ')', diff);
        } else if (diff < 0) {
            appendChars(res, '(', -diff);
        }
    }

    private static void appendChars(StringBuilder sb, char c, int times) {
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
    }

    private static int getInt(String s, int i) {
        return s.charAt(i) - '0';
    }
}
