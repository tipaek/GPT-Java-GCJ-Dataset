import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    private static final String[] OPENING_DEPTH = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
    private static final String[] CLOSING_DEPTH = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() throws IOException {
        Input input = new Input();
        int t = input.readInt();
        for (int caseId = 1; caseId <= t; caseId++) {
            char[] s = input.readLine().toCharArray();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                int end = result.length() - 1;
                if (end < 0 || result.charAt(end) == ')') {
                    int digit = Character.digit(s[i], 10);
                    result.append(OPENING_DEPTH[digit]).append(s[i]);
                } else {
                    char endChar = result.charAt(end);
                    if (endChar == s[i]) {
                        result.append(s[i]);
                    } else if (endChar < s[i]) {
                        result.append(OPENING_DEPTH[s[i] - endChar]).append(s[i]);
                    } else {
                        result.append(CLOSING_DEPTH[endChar - s[i]]).append(s[i]);
                    }
                }
            }
            char lastChar = result.charAt(result.length() - 1);
            if (Character.isDigit(lastChar)) {
                int digit = Character.digit(lastChar, 10);
                result.append(CLOSING_DEPTH[digit]);
            }
            System.out.printf("Case #%d: %s\n", caseId, result.toString());
        }
    }

    private static class Input {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        String readLine() throws IOException {
            return br.readLine();
        }
    }
}