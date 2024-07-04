import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private int MB = 1<<20;
    private int SIZE = 20 * MB;

    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    static int readInt() throws IOException {
        String line = br.readLine();
        return Integer.parseInt(line.trim());
    }

    static String readLine() throws IOException {
        String line = br.readLine();
        return line;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        for (int i = 0; i < T; ++i) {
            String S = readLine();
            Result res = solve(i+1, S);
            sb.append(res.toString());
        }
        System.out.print(sb);
    }

    public static Result solve(int x, String S) {
        Result res = new Result();
        res.x = x;
        res.y = convert(S + "x");
        return res;
    }

    private static String convert(String S) {
        StringBuilder sb = new StringBuilder();
        // state 0
        int cb = 0;
        for (int i = 0; i < S.length(); i++) {
            char cc = S.charAt(i);
            if (cc == 'x') {
                for (int j = 0; j < cb; j++) {
                    sb.append(')');
                }
            } else {
                int cd = cc - '0';
                while (cb < cd) {
                    sb.append('(');
                    ++cb;
                }
                while (cb > cd) {
                    sb.append(')');
                    --cb;
                }
                sb.append(cc);
            }
        }

        return sb.toString();
    }

    static class Result {
        int x;
        String y;

        @Override
        public String toString() {
            return String.format("Case #%d: %s%n", x, y);
        }
    }
}
