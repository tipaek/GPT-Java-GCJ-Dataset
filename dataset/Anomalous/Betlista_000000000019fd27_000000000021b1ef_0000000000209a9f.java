import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final int MB = 1 << 20;
    private static final int SIZE = 20 * MB;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    private static String readLine() throws IOException {
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        for (int i = 0; i < T; ++i) {
            String S = readLine();
            Result res = solve(i + 1, S);
            sb.append(res);
        }
        System.out.print(sb);
    }

    private static Result solve(int x, String S) {
        Result res = new Result();
        res.x = x;
        res.y = convert(S + "x");
        return res;
    }

    private static String convert(String S) {
        StringBuilder sb = new StringBuilder();
        int openBrackets = 0;
        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            if (currentChar == 'x') {
                while (openBrackets > 0) {
                    sb.append(')');
                    openBrackets--;
                }
            } else {
                int digit = currentChar - '0';
                while (openBrackets < digit) {
                    sb.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    sb.append(')');
                    openBrackets--;
                }
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    private static class Result {
        int x;
        String y;

        @Override
        public String toString() {
            return String.format("Case #%d: %s%n", x, y);
        }
    }
}