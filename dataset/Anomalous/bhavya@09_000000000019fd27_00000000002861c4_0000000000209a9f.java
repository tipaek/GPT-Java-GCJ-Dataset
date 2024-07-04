import java.io.*;
import java.util.*;

public class Code5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str = br.readLine();
            int n = str.length();
            char[] st = str.toCharArray();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int d = st[i] - '0';

                if (i == 0) {
                    appendParentheses(result, d, true);
                    result.append(st[i]);
                    if (shouldSkipNextCharacter(st, n, i)) {
                        result.append(st[++i]);
                    }
                } else {
                    if (st[i - 1] == '0') {
                        appendParentheses(result, d, true);
                    } else {
                        appendParentheses(result, d - 1, true);
                    }
                    result.append(st[i]);
                    if (shouldSkipNextCharacter(st, n, i)) {
                        result.append(st[++i]);
                    }
                }

                if (i == n - 1 || (i + 1 < n && st[i + 1] == '0')) {
                    appendParentheses(result, d, false);
                } else {
                    appendParentheses(result, d - 1, false);
                }
            }

            System.out.println(result.toString());
        }
    }

    private static void appendParentheses(StringBuilder sb, int count, boolean open) {
        for (int j = 0; j < count; j++) {
            sb.append(open ? '(' : ')');
        }
    }

    private static boolean shouldSkipNextCharacter(char[] st, int n, int i) {
        return i + 1 < n && st[i + 1] == st[i];
    }
}